/*
INF - > Empty Room
0 -> Gate
-1 -> wall or obstacles
Find the path to its nearest gate
 */

package Facebook.MostlyAsked;

import java.util.Arrays;

public class FindEmptyRoom
{
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String args[])
    {
        int[][] grid = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };
        FindEmptyRoom f = new FindEmptyRoom();
        f.findMinimumDistanceToEmptyRoom(grid);
        for (int[] g : grid) {
            System.out.println(Arrays.toString(g));
        }
    }

    private void findMinimumDistanceToEmptyRoom(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    findMinimumDistanceToEmptyRoomHelper(grid, i, j, visited, 0);
                }
            }
        }
    }

    private boolean check(int[][] grid, int i, int j, boolean[][] visited){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] <= 0){
            return false;
        }
        return true;
    }

    private void findMinimumDistanceToEmptyRoomHelper(int[][] grid, int i, int j, boolean[][] visited, int count)
    {
        visited[i][j] = true;
        if(check(grid, i + 1, j, visited)){
            findMinimumDistanceToEmptyRoomHelper(grid, i + 1, j, visited, count + 1 );
        }
        if(check(grid, i - 1, j, visited)){
            findMinimumDistanceToEmptyRoomHelper(grid, i - 1, j, visited, count + 1 );
        }
        if(check(grid, i, j + 1, visited)){
            findMinimumDistanceToEmptyRoomHelper(grid, i, j + 1, visited, count + 1 );
        }
        if(check(grid, i, j - 1, visited)){
            findMinimumDistanceToEmptyRoomHelper(grid, i, j - 1, visited, count + 1 );
        }
        grid[i][j] = Math.min(grid[i][j], count);
        visited[i][j] = false;
    }

}
