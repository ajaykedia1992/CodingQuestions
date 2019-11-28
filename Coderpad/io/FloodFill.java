
package Coderpad.io;

import java.util.Arrays;

public class FloodFill
{
    public static void main(String args[]){
        int[][] image = {
                {1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1},
                {1, 1, 2, 2, 1, 1},
                {2, 2, 2, 2, 1, 2}
        };

        int clickedColumn[] = {2,2};
        int newValue = 3;
        FloodFill f = new FloodFill();
        f.floodFill(image, clickedColumn, newValue);
        for(int[] row : image){
            System.out.println(Arrays.toString(row));
        }
    }

    private void floodFill(int[][] image, int[] clickedColumn, int newValue)
    {
        int row = clickedColumn[0];
        int col = clickedColumn[1];
        int currentValue = image[row][col];
        floodFillHelper(image, row, col, currentValue, newValue);
    }

    private void floodFillHelper(int[][] image, int row, int col, int currentValue, int newValue)
    {
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != currentValue){
            return;
        }
        image[row][col] = newValue;
        floodFillHelper(image, row + 1, col, currentValue, newValue);
        floodFillHelper(image, row - 1, col, currentValue, newValue);
        floodFillHelper(image, row, col + 1, currentValue, newValue);
        floodFillHelper(image, row, col - 1, currentValue, newValue);
    }
}
