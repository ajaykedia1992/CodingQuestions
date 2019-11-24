package ByteByByte;

import java.util.Arrays;

/*
    Given a matrix, find the path from top left to bottom right with the
    greatest product by moving only down and right.
    [‑1, 2, 3]
    [4, 5, ‑6]
    [7, 8, 9]
    ‑1 ‑> 4 ‑> 5 ‑> ‑6 ‑> 9
    1080
    [-1, -2, -6]    [-1, -2, -6]
    [-4, -10, 60]   [-4, -20, 36]
    [-28, -80, 5]   [-28, 0, 0]

 */
public class MatrixProduct
{
    public static void main(String args[])
    {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, -9}
        };
        MatrixProduct m = new MatrixProduct();
        long matrixProduct = m.getMatrixProduct(arr);
        System.out.println(matrixProduct);
    }

    private int getMatrixProduct(int[][] arr)
    {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }

        int m = arr.length;
        int n = arr[0].length;
        int[][] maxValue = new int[m][n];
        int[][] minValue = new int[m][n];
        maxValue[0][0] = arr[0][0];
        minValue[0][0] = arr[0][0];
        for(int i = 1; i < m; i++){ // row
            maxValue[i][0] = maxValue[i-1][0] * arr[i][0];
            minValue[i][0] = minValue[i-1][0] * arr[i][0];
        }
        for(int i = 1; i < n; i++){ // col
            maxValue[0][i] = maxValue[0][i - 1] * arr[0][i];
            minValue[0][i] = minValue[0][i - 1] * arr[0][i];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                maxValue[i][j] = max(new int[]{maxValue[i - 1][j], maxValue[i][j-1], minValue[i - 1][j], minValue[i][j-1]}, arr[i][j]);
                minValue[i][j] = min(new int[]{maxValue[i - 1][j], maxValue[i][j-1], minValue[i - 1][j], minValue[i][j-1]}, arr[i][j]);
            }
        }
        //display(maxValue);
        return maxValue[m - 1][n-1] > minValue[m-1][n-1] ? maxValue[m-1][n-1] : minValue[m-1][n-1];
    }

    private int max(int[] values, int val){
        int max = Integer.MIN_VALUE;
        for(int i : values){
            if(max < i * val){
                max = i * val;
            }
        }
        return max;
    }

    private int min(int[] values, int val){
        int min = Integer.MAX_VALUE;
        for(int i : values){
            if(min > i * val){
                min = i * val;
            }
        }
        return min;
    }

    private void display(int[][] arr){
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}
