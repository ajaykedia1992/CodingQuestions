package Leetcode;

public class IslandPerimeter {

    int count = 0;
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int perimeter = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    perimeter += islandPerimeterUtil(grid, i, j);
                }
            }
        }
        return perimeter;
    }
    /*
    [[0,1,0,0],
     [1,1,1,0],
     [0,1,0,0],
    [1,1,0,0]]
     */

    public boolean checkGrid(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 ){
            return true;
        }
        return false;
    }

    public int islandPerimeterUtil(int[][] grid, int i, int j){
        int count = 0;
        if(checkGrid(grid, i + 1, j)){
            count++;
        }
        if(checkGrid(grid, i - 1, j)){
            count++;
        }
        if(checkGrid(grid, i, j + 1)){
            count++;
        }
        if(checkGrid(grid, i, j - 1)){
            count++;
        }
        return count;
    }

    public static void main(String args[]){
        int island[][] = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        IslandPerimeter ip = new IslandPerimeter();
        int perimeter = ip.islandPerimeter(island);
        System.out.println(perimeter);
    }
}
