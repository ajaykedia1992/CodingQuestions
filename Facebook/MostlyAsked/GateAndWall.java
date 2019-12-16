package Facebook.MostlyAsked;

import java.util.Arrays;

public class GateAndWall
{
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String args[]){
        int[][] grid = {
                {-1, -1, 0, INF},
                {-1, -1, INF, INF},
                {INF, INF, INF, INF},
                {INF, 0, INF, INF}
        };

        GateAndWall g = new GateAndWall();
        g.getMinimumDistance(grid);

        for(int i[] : grid){
            System.out.println(Arrays.toString(i));
        }
    }

    private void getMinimumDistance(int[][] grid)
    {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    DFS(grid, i, j, visited, 0);
                }
            }
        }
    }

    private boolean check(int[][] grid, int i, int j, boolean[][]visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] <= 0){
            return false;
        }
        return true;
    }

    private void DFS(int[][] grid, int i, int j, boolean[][] visited, int count)
    {
        visited[i][j] = true;
        grid[i][j] = Math.min(grid[i][j], count);
        if(check(grid, i + 1, j, visited)){
            DFS(grid, i + 1, j, visited, count + 1);
        }
        if(check(grid, i - 1, j, visited)){
            DFS(grid, i-1, j, visited, count + 1);
        }
        if(check(grid, i, j + 1, visited)){
            DFS(grid, i, j + 1, visited, count + 1);
        }
        if(check(grid, i, j - 1, visited)){
            DFS(grid, i, j - 1, visited, count + 1);
        }

        visited[i][j] = false;
    }
}
