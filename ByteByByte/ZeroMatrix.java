/*
Given a boolean matrix, update it so that if any cell is true, all the cells
in that row and column are true
[true,  false, false]      [true,  true,  true ]
[false, false, false]  ‑>  [true,  false, false]
[false, false, false]      [true,  false, false]
 */
package ByteByByte;

import java.util.Arrays;

public class ZeroMatrix
{
    public static void main(String args[]){
        ZeroMatrix z = new ZeroMatrix();
        boolean[][] matrix = {
                {false,  false, false},
                {false, false, false},
                {false, false, true}
        };

        z.getZeroMatrix(matrix);
        z.display(matrix);
    }

    private void getZeroMatrix(boolean[][] matrix)
    {
        boolean rowZero = false;
        boolean colZero = false;

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i]){
                rowZero |= matrix[0][i];
                break;
            }
        }
        for(int i = 0; i< matrix.length; i++){
            if(matrix[i][0]){
                colZero |= matrix[i][0];
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0]. length; j++){
                if(matrix[i][j]){
                    matrix[i][0] |= matrix[i][j];
                    matrix[0][j] |= matrix[i][j];
                }
            }
        }

        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i]){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = true;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0]){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = true;
                }
            }
        }

        if(rowZero){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = true;
            }
        }
        if(colZero){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = true;
            }
        }

    }

    public void display(boolean[][] matrix){
        for(boolean[] m : matrix){
            System.out.println(Arrays.toString(m));
        }
    }
}
