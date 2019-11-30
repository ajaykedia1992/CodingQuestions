package Coderpad.io;

public class IslandPerimeter
{
    public static void main(String args[]){
        int[][] island = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        
        IslandPerimeter i = new IslandPerimeter();
        int perimeter = i.getPerimeter(island);
        System.out.println(perimeter);
    }

    private int getPerimeter(int[][] island)
    {
        if(island == null){
            return 0;
        }
        int perimeter = 0;
        for(int i = 0; i < island.length; i++){
            for(int j = 0; j < island[0].length; j++){
                if(island[i][j] == 1){
                    perimeter += getPerimeter(island, i, j);
                }
            }
        }
        return perimeter;
    }

    private boolean checkBoundary(int[][] island, int i, int j){
        if(i < 0 || i >= island.length || j < 0 || j >= island[0].length || island[i][j] == 0){
            return true;
        }
        return false;
    }

    private int getPerimeter(int[][] island, int i, int j)
    {
        int count = 0;
        if(checkBoundary(island, i + 1, j)){
            count++;
        }
        if(checkBoundary(island, i - 1, j)){
            count++;
        }
        if(checkBoundary(island, i, j + 1)){
            count++;
        }
        if(checkBoundary(island, i, j - 1)){
            count++;
        }
        return count;
    }
}
