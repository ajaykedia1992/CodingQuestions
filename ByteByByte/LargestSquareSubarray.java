package ByteByByte;

import java.util.Arrays;

public class LargestSquareSubarray
{
    public static void main(String args[]){
        int [][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0 , 0}
        };

        LargestSquareSubarray l = new LargestSquareSubarray();
        int dimensions = l.getLargestSquareSubarray(matrix);
        System.out.println(dimensions);
    }

    private int getLargestSquareSubarray(int[][] matrix)
    {
        if(matrix == null || matrix.length == 0){
            throw new IllegalArgumentException();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int maxDimensions = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == 1){
                        maxDimensions = 1;
                    }
                }
                else{
                    if(matrix[i][j] == 0){
                        continue;
                    }
                    else{
                       matrix[i][j] = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1])  + 1;
                       if(maxDimensions < matrix[i][j]){
                           maxDimensions = matrix[i][j];
                       }
                    }
                }
            }
        }

        display(matrix);
        return maxDimensions;
    }

    public void display(int[][] matrix){
        for(int[]  i : matrix){
            System.out.println(Arrays.toString(i));
        }
    }
}
