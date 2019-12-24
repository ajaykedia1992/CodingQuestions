/*

 */
package Facebook.PreviousInterviews.FacebookPremium;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord
{
    class Trie{
        Map<Character, Trie> children;
        boolean isEnd;
        Trie(){
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }

    Trie root;
    AddAndSearchWord(){
        root = new Trie();
    }
    public static void main(String args[]){
        AddAndSearchWord a = new AddAndSearchWord();
        a.addWord("bad");
        a.addWord("dad");
        a.addWord("mad");

        System.out.println(a.search("pad"));
        System.out.println(a.search("bad"));
        System.out.println(a.search(".ad"));
        System.out.println(a.search("b.."));
    }

    private boolean search(String word)
    {
        Trie temp = root;
        return searchUtil(word, 0, temp);
    }

    private boolean searchUtil(String word, int pos, Trie node)
    {
        if(pos == word.length()) return node.isEnd;

        if(node.children.size() == 0) return false;

        if(word.charAt(pos) == '.'){
            for(char t : node.children.keySet()){
                if(searchUtil(word, pos + 1, node.children.get(t))){
                    return true;
                }
            }
        }

        if(!node.children.containsKey(word.charAt(pos))){
            return false;
        }

        return searchUtil(word, pos + 1, node.children.get(word.charAt(pos)));
    }

    private void addWord(String s)
    {
        Trie temp = root;
        for(char c : s.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c, new Trie());
            }
            temp = temp.children.get(c);
        }
        temp.isEnd = true;
    }
}
