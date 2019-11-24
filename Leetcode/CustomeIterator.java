package Leetcode;

import java.util.Arrays;
import java.util.Iterator;

class Tuple{
    String word;
    int count;

    Tuple(String word, int count){
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString(){
        return "(word = " + word + ", count = " + count + ")";
    }
}

public class CustomeIterator {

    private String currentWord;
    private final Iterator<String> customIterator;

    CustomeIterator(Iterator<String> customIterator){
        this.customIterator = customIterator;
    }

    private Tuple next() {
        if(!this.hasNext()){
            return null;
        }
        String prevWord = currentWord;
        int count = currentWord == null ? 0 : 1;
        currentWord = null;
        String iterWord = "";
        while(customIterator.hasNext()){
            iterWord = customIterator.next();
            if(prevWord == null){
                 currentWord =prevWord = iterWord;
            }if(!iterWord.equals(currentWord)) {
                currentWord = iterWord;
                break;
            }
            count++;
        }
        return new Tuple(prevWord, count);
    }

    private boolean hasNext() {
        return currentWord != null || this.customIterator.hasNext();
    }

    public static void main(String args[]){
        String words[] = { "foo", "foo", "foo", "bar", "Hello", "foo" };
        Iterator<String> iter = Arrays.asList(words).iterator();
        CustomeIterator customeIterator = new CustomeIterator(iter);

        while(customeIterator.hasNext()){
            System.out.println(customeIterator.next());
        }
    }
}
