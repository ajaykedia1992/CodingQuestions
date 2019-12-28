package Facebook.MostlyAsked.Important;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class WordBuilder {

    public static void main(String args[]) {
        String startWord = "hit";
        String endWord = "cog";
        String[] arr = { "hot", "dot", "dog", "lot", "log" };
        Map<String, Boolean> wordDict = new HashMap<>();
        for (String s : arr) {
            wordDict.put(s, true);
        }

        WordBuilder w = new WordBuilder();
        System.out.println(w.findMinimumPath(startWord, endWord, wordDict));

    }

    public int findMinimumPath(String startWord, String endWord, Map<String, Boolean> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(startWord, 1));

        wordDict.put(endWord, true);

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) {
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (wordDict.containsKey(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }
}