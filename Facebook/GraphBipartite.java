/*
index 0 -> {1, 3},
index 1 -> {0, 2},
index 2 -> {1, 3},
index 3 -> {0, 2},

 0 ------------ 1
 |              |
 |              |
 |              |
 3 ------------ 2
 */
package Facebook;

public class GraphBipartite
{
    public static void main(String args[]){
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2},
        };
        System.out.println(new GraphBipartite().isBipartite(graph));
    }

    private boolean isBipartite(int[][] graph)
    {
        if(graph == null || graph.length == 0){
            return false;
        }
        int n = graph.length;
        int colors[] = new int[n];
        for(int i = 0; i < n; i++){
            if(colors[i] == 0 && !checkBoundary(graph, colors, 1, i)){
                return false;
            }
        }
        return true;
    }

    private boolean checkBoundary(int[][] graph, int[] colors, int colorCode, int index)
    {
        if(colors[index] != 0){
            return colors[index] == colorCode;
        }
        colors[index] = colorCode;
        for(int vertex : graph[index]){
            if(!checkBoundary(graph, colors, -colorCode, vertex)){
                return false;
            }
        }
        return true;
    }
}
