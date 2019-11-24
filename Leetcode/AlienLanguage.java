package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Graph{

    private final LinkedList<Integer>[] adjacencyList;

    public Graph(int no_of_vertex){
        adjacencyList = new LinkedList[no_of_vertex];
        for(int i = 0; i < no_of_vertex; i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    private int getNumberOfVertex(){
        return this.adjacencyList.length;
    }

    public void addEdges(int from, int to) {
        this.adjacencyList[from].add(to);
    }

    public void topologicalSorting() {
        Stack<Integer> stack = new Stack<>();
        boolean[] vertex = new boolean[getNumberOfVertex()];

        for(int i = 0; i<getNumberOfVertex(); i++){
            vertex[i] = false;
        }

        for(int i = 0; i < getNumberOfVertex(); i++){
            if(!vertex[i]){
                topologicalSortingUtil(i, vertex, stack);
            }
        }
        printStackValue(stack);
    }

    private void printStackValue(Stack<Integer> stack) {
        while(!stack.isEmpty()){
            System.out.print((char)(stack.pop() + 'a') + " ");
        }
    }

    private void topologicalSortingUtil(int i, boolean[] vertex, Stack<Integer> stack) {
        vertex[i] = true;
        for(int d : adjacencyList[i]){
            if(!vertex[d]){
                topologicalSortingUtil(d, vertex, stack);
            }
        }
        stack.push(i);
    }
}


public class AlienLanguage {
    public static void main(String args[]) {
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        int no_of_alphabets = 4;
        printAlphabets(arr, no_of_alphabets);
    }

    private static void printAlphabets(String[] arr, int no_of_alphabets) {
        createGraph(arr, no_of_alphabets);
    }

    private static void createGraph(String[] arr, int no_of_alphabets) {
        Graph g = new Graph(no_of_alphabets);

        for(int i = 0; i < arr.length - 1; i++){
            String word1 = arr[i];
            String word2 = arr[i + 1];
            //int j = 0;

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    g.addEdges(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
                    break;
                }
            }
        }
        g.topologicalSorting();
    }
}
