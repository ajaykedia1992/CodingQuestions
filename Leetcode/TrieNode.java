package Leetcode;

import java.util.HashMap;
import java.util.Map;

class Trie{
    boolean isEndOfWord;
    Map<Character, Trie> childrenMap;

    Trie(){
        isEndOfWord = false;
        childrenMap = new HashMap<>();
    }
}

public class TrieNode {

    Trie root;

    TrieNode(){
        root = new Trie();
    }

    private void insert(String word){
        insertUtil(root, word);
    }

    private void insertUtil(Trie currentNode, String word) {
        if(word == null || word.length() == 0){
            return;
        }
        char[] wordChar = word.toCharArray();
        Trie temp = null;
        for(int i = 0; i < wordChar.length; i++){
            char c = wordChar[i];
            temp = currentNode.childrenMap.get(c);
            if(temp == null){
                temp = new Trie();
                currentNode.childrenMap.put(c, temp);
            }
            currentNode = temp;
        }
        currentNode.isEndOfWord = true;
    }

    private boolean search(String word){

        return searchUtil(root, word);
    }

    private boolean searchUtil(Trie currentNode, String word) {

        if(word == null || word.length() == 0){
            return false;
        }
        char[] wordChar = word.toCharArray();
        Trie temp = null;
        for(int i = 0; i<wordChar.length; i++){
            temp = currentNode.childrenMap.get(wordChar[i]);
            if(temp == null){
                return false;
            }
            currentNode = temp;
        }
        return currentNode.isEndOfWord;
    }

    private boolean delete(String word){
        return deleteUtil(root, word, 0);
    }

    private boolean deleteUtil(Trie currentNode, String word, int index) {
        if(index == word.length()){
            if(currentNode.isEndOfWord){
                currentNode.isEndOfWord = false;
                return currentNode.childrenMap.size() == 0;
            }else{
                return false;
            }
        }

        Trie temp = currentNode.childrenMap.get(word.charAt(index));
        if(temp == null){
            return false;
        }
        boolean shouldBeDeleted = deleteUtil(temp, word, index + 1);

        if(shouldBeDeleted){
            temp.childrenMap.remove(word.charAt(index));
            return temp.childrenMap.size() == 0;
        }
        return false;
    }

    public static void main(String args[]){

        TrieNode root = new TrieNode();
        String words[] = { "abcd", "abc", "def", "mno", "bcf" };
        System.out.println("words are adding to tree");
        for(int i = 0; i < words.length; i++){
            root.insert(words[i]);
        }
        System.out.println("Words are added");
        String testWord[] = { "abc", "def", "mno", "ab", "bcf" };
        for(int i = 0; i < testWord.length; i++){
            System.out.print(root.search(testWord[i]) + " ");
        }
        System.out.println();

        System.out.println("deleteWords");
        String deleteWords[] = {"mno", "abc", "abcde", "bcf"};
        for(int i = 0; i<deleteWords.length; i++){
            System.out.print(root.delete(deleteWords[i]) + " ");
        }
        System.out.println();
        System.out.println("Searching the same words");
        for(int i = 0; i < testWord.length; i++){
            System.out.print(root.search(testWord[i]) + " ");
        }
        System.out.println();

    }
}


