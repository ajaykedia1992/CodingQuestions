package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StringIterator {

    Queue<int[]> queue = new LinkedList<>();

    public StringIterator(String str){
        int n = str.length();
        for(int i = 0; i < n;){
            int j = i + 1;
            while(j < n && str.charAt(j) - 'A' < 0){
                j++;
            }
            queue.add(new int[] {str.charAt(i) - 'A', Integer.parseInt(str.substring(i + 1, j))});
            i = j;
        }
    }

    private char next() {
        if(queue.isEmpty()){
            return ' ';
        }
        int[] top = queue.peek();
        if(--top[1] == 0){
            queue.poll();
        }
        return (char)(top[0] + 'A');
    }

    private boolean hasNext() {
        if(queue.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        String str = "L1E2T1C1O1D1E1";
        StringIterator stringIterator = new StringIterator(str);
        while(stringIterator.hasNext()){
            System.out.print(stringIterator.next());
        }
    }
}
