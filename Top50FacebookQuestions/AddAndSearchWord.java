/*
https://leetcode.com/problems/add-and-search-word-data-structure-design/
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
package Top50FacebookQuestions;

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
    /** Initialize your data structure here. */
    Trie root;
    public AddAndSearchWord() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie temp = root;
        for(char c : word.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c, new Trie());
            }
            temp = temp.children.get(c);
        }
        temp.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Trie temp = root;
        return search(temp, 0, word);
    }

    public boolean search(Trie node, int pos, String word){
        if(pos == word.length()) return node.isEnd;

        if(node.children.size() == 0) return false;

        char c = word.charAt(pos);

        if(c == '.'){
            for(char ch : node.children.keySet()){
                if(search(node.children.get(ch), pos + 1, word)){
                    return true;
                }
            }
        }

        if(!node.children.containsKey(c)){
            return false;
        }
        return search(node.children.get(c), pos + 1, word);
    }
}
