package Facebook;

import java.util.HashMap;
import java.util.Map;

class Trie
{
    Map<Character, Trie> children;
    boolean isEnd;

    public Trie()
    {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

public class MagicDictionary
{
    Trie root;

    public MagicDictionary()
    {
        root = new Trie();
    }

    public static void main(String args[])
    {
        String[] dict = {"hello", "leetcode"};
        String search = "hello";
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(dict);
        System.out.println(magicDictionary.search(search));
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict)
    {
        for(String d : dict){
            insert(d);
        }
    }

    public void insert(String word){
        Trie curr = this.root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new Trie());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word)
    {
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char a = arr[i];
            Trie curr = this.root;
            for (char c = 'a'; c <= 'z'; c++) {
                if (a == c) continue;
                arr[i] = c;
                if (find(new String(arr), curr, 0)){
                    return true;
                }
                arr[i] = a;
            }
        }
        return false;
    }

    private boolean find(String s, Trie curr, int index)
    {
        if(curr == null){
            return false;
        }
        if(index  == s.length()){
            return curr.isEnd;
        }
        return find(s, curr.children.get(s.charAt(index)), index + 1);
    }

}
