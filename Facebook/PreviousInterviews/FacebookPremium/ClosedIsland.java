/*
https://leetcode.com/problems/number-of-closed-islands/submissions/
 */
package Facebook.PreviousInterviews.FacebookPremium;

public class ClosedIsland
{

    public static void main(String args[]){
        int[][] grid = {
                {0,0,1,1,0,1,0,0,1,0},
                {1,1,0,1,1,0,1,1,1,0},
                {1,0,1,1,1,0,0,1,1,0},
                {0,1,1,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,1,1,1,0},
                {0,1,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,1,0,0,0,1},
                {1,1,1,1,1,1,0,0,0,0},
                {1,1,1,0,0,1,0,1,0,1},
                {1,1,1,0,1,1,0,1,1,0}
        };

        System.out.println(new ClosedIsland().closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    if(checkBoundary(grid, i, j))res++;
                }
            }
        }

        return res;
    }

    public boolean checkBoundary(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;

        if(grid[i][j] == 1) return true;

        grid[i][j] = 1;
        /*
        for(int[] d : dir){
            res = res & checkBoundary(grid, x + d[0], y + d[1]);
        }
        return res;*/

        return checkBoundary(grid, i + 1, j) & checkBoundary(grid, i - 1, j) & checkBoundary(grid, i, j + 1) & checkBoundary(grid, i, j - 1);
    }
}
