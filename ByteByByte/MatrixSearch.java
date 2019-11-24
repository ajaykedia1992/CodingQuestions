/*
Given an n x m array where all rows and columns are in sorted order,
write a function to determine whether the array contains an element x.
 */
package ByteByByte;

public class MatrixSearch
{
    public static void main(String args[]){
        MatrixSearch m = new MatrixSearch();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
        };

        boolean isPresent = m.matrixSearch(matrix, 100);
        System.out.println(isPresent);
    }

    private boolean matrixSearch(int[][] matrix, int value)
    {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(value == matrix[row][col]) return true;
            if(matrix[row][col] < value) row++;
            else col--;
        }
        return false;
    }
}
