/*
https://www.youtube.com/watch?v=NZ3lP33mXlY
 */
package ByteByByte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoComplete
{
    class TrieNode{
        String prefix;
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode(String prefix){
            this.prefix = prefix;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    TrieNode root;
    AutoComplete(String dict[]){
        root = new TrieNode("");
        for(String word : dict){
            insert(word);
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))){
                curr.children.put(word.charAt(i), new TrieNode(word.substring(0, i + 1)));
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isEnd = true;
    }

    private List<String> search(String pre)
    {
        List<String> res = new ArrayList<>();
        TrieNode curr = root;
        for(char c : pre.toCharArray()){
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            }else{
                return res;
            }
        }

        findAllWord(curr, res);
        return res;
    }

    private void findAllWord(TrieNode curr, List<String> res)
    {
        if(curr.isEnd) res.add(curr.prefix);

        for(char c : curr.children.keySet()){
            findAllWord(curr.children.get(c), res);
        }
    }

    public static void main(String args[]){
        String[] dict = {"abc", "a", "abcd", "acd", "bc", "bcd", "bcde"};
        AutoComplete a = new AutoComplete(dict);
        System.out.println(a.search("a"));
        System.out.println(a.search("b"));
    }
}
