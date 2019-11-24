package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String args[]){
        int[][] matrix = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, {
                10, 9, 8, 7 } };

        SpiralMatrix sm = new SpiralMatrix();
        sm.printSpiralMatrix(matrix, matrix.length, matrix[0].length);
    }

    private void printSpiralMatrix(int[][] matrix, int m, int n) {
        if(matrix == null || m == 0){
            throw new IllegalArgumentException("matrix is empty");
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = m - 1;
        int colEnd = n - 1;
        List<Integer> result = new ArrayList<>();

        while(rowStart <= rowEnd && colStart <= colEnd){

            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            for(int i = rowStart + 1; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }

            if(rowStart < rowEnd && colStart < colEnd){
                for(int i = colEnd - 1; i >= rowStart; i--){
                    result.add(matrix[rowEnd][i]);
                }

                for(int i = rowEnd - 1; i > rowStart; i--){
                    result.add(matrix[i][rowStart]);
                }
            }

            rowStart++;
            rowEnd--;
            colEnd--;
            colStart++;
        }
        result.stream().forEach(x -> System.out.println(x));
    }
}
