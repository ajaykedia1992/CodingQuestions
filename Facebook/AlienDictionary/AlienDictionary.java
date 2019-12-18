package Facebook.AlienDictionary;

import sun.awt.image.ImageWatched.Link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary
{
    public String alienOrder(String[] words)
    {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indexMap = new HashMap<>();
        constructGraph(graph, words, indexMap);
        return topologicalSort(indexMap, graph);
    }

    private String topologicalSort(Map<Character, Integer> indexMap, Map<Character, List<Character>> graph)
    {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : indexMap.entrySet()){
            if(entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            char temp = queue.poll();
            str.append(temp);
            for(char adj : graph.getOrDefault(temp, new LinkedList<>())){
                indexMap.put(adj, indexMap.getOrDefault(adj, 0) - 1);
                if(indexMap.get(adj) == 0){
                    queue.add(adj);
                }
            }
        }

        return str.length() == indexMap.size() ? str.toString() : "";
    }

    private void constructGraph(Map<Character, List<Character>> graph, String[] words, Map<Character, Integer> indexMap)
    {
        for(String w : words){
            for(char c : w.toCharArray()){
                indexMap.putIfAbsent(c, 0);
            }
        }

        for(int i = 1; i < words.length; i++){
            String word1 = words[i - 1];
            String word2 = words[i];

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    List<Character> adjacency = graph.getOrDefault(c1, new LinkedList<>());
                    adjacency.add(c2);
                    graph.put(c1, adjacency);
                    indexMap.put(c2, indexMap.getOrDefault(c2, 0) + 1);
                    break;
                }
            }
        }
    }

    public static void main(String args[]){
        String words[] = {"z", "z"};

        AlienDictionary a = new AlienDictionary();
        String res = a.alienOrder(words);
        System.out.println(res);
    }

}
