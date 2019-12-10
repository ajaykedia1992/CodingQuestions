package Facebook.PhoneDirectory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory
{
    class Trie{
        Map<Character, Trie> children = null;
        boolean isLast;
        Trie(){
            this.children = new HashMap<>();
            this.isLast = false;
        }
    }

    Trie root;
    PhoneDirectory(){
        root = new Trie();
    }

    private void insertDirectory(String[] contacts)
    {
        for(String s : contacts){
            Trie current = this.root;
            for(char c : s.toCharArray()){
                if(!current.children.containsKey(c)){
                    current.children.put(c, new Trie());
                }
                current = current.children.get(c);
            }
            current.isLast = true;
        }
    }


    private void searchDirectory(String query)
    {
        Trie current = this.root;
        String prefix = "";
        int i;
        for(i = 0; i < query.length(); i++){
            prefix += query.charAt(i);
            char lastChar = prefix.charAt(i);
            Trie temp = current.children.get(lastChar);
            if(temp == null){
                System.out.println("No words for the prefix = " + prefix);
                i++;
                break;
            }
            System.out.println("found word for the prefix = " + prefix);
            discoverWords(temp, prefix);
            current = temp;
        }

        for(; i < query.length(); i++){
            prefix += query.charAt(i);
            System.out.println("No words for the prefix = " + prefix);
        }
    }

    private void discoverWords(Trie temp, String prefix)
    {
        if(temp.isLast){
            System.out.println(prefix);
        }

        for(char c = 'a'; c <= 'z'; c++){
            if(temp.children.containsKey(c)){
                discoverWords(temp.children.get(c), prefix + c);
            }
        }
    }

    public static void main(String args[])
    {
        String contacts[] = {"gforgeeks", "geeksquiz"};
        PhoneDirectory p = new PhoneDirectory();
        p.insertDirectory(contacts);

        System.out.println("Words are inserted in the dictionary");

        String query = "gekk";

        p.searchDirectory(query);
    }

}
