/*
https://leetcode.com/problems/alien-dictionary/
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
Derive the order of letters in this language.

Example 1:
Input: ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Example 2:
Input: ["z","x"]
Output: "zx"

Example 3:
Input:
["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

Note:
1. You may assume all letters are in lowercase.
2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
3. If the order is invalid, return an empty string.
4. There may be multiple valid order of letters, return any one of them is fine.

 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary
{
    public static void main(String args[])
    {
        String words[] = {"z", "x", "z"};
        AlienDictionary dictionary = new AlienDictionary();
        String output = dictionary.alienOrder(words);
        System.out.println(output);
    }

    public String alienOrder(String[] words)
    {
        if (words == null || words.length == 0) {
            return "";
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();

        constructGraph(indexMap, graph, words);

        return getAlienOrder(indexMap, graph);
    }

    public String getAlienOrder(Map<Character, Integer> indexMap, Map<Character, List<Character>> graph)
    {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : indexMap.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for(char adj : graph.getOrDefault(c, new ArrayList<>())){
                indexMap.put(adj, indexMap.getOrDefault(adj, 0) - 1);
                if(indexMap.get(adj) == 0){
                    queue.add(adj);
                }
            }
        }

        return sb.length() != indexMap.size() ? "" : sb.toString();
    }

    public void constructGraph(Map<Character, Integer> indexMap, Map<Character, List<Character>> graph, String[] words)
    {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indexMap.putIfAbsent(c, 0);
            }
        }

        // construct graph
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    List<Character> adjacency = graph.getOrDefault(c1, new ArrayList<>());
                    adjacency.add(c2);
                    graph.put(c1, adjacency);
                    indexMap.put(c2, indexMap.getOrDefault(c2, 0) + 1);
                    break;
                }
            }
        }
    }
}
