/*
1-> represent Island
0-> Water Body
Find the number of island exists.
 */
package Facebook;

public class NumberOfIsland
{
    public static void main(String args[]){
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}
        };

        NumberOfIsland n = new NumberOfIsland();
        int count = n.getNumberOfIsland(grid);
        System.out.println(count);
    }

    private int getNumberOfIsland(int[][] grid)
    {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                    getNumberOfIslandHelper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void getNumberOfIslandHelper(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;
        getNumberOfIslandHelper(grid, i + 1, j);
        getNumberOfIslandHelper(grid, i - 1, j);
        getNumberOfIslandHelper(grid, i, j + 1);
        getNumberOfIslandHelper(grid, i, j - 1);

    }

}
