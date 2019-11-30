/*
find the unique path from top left cell to bottom right cell.
 */

package Facebook;

public class UniquePath
{
    public static void main(String args[]){
        int m = 7; int n = 3;
        UniquePath u = new UniquePath();
        int uniquePath = u.getUniquePath(m, n);
        System.out.println(uniquePath);
    }

    private int getUniquePath(int m, int n)
    {
        int[][] uniquePathMatrix = new int[m][n];
        for(int i = 0; i < m; i++){
            uniquePathMatrix[i][0] = 1;
        }

        for(int i = 0; i < n; i++){
            uniquePathMatrix[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                uniquePathMatrix[i][j] = uniquePathMatrix[i - 1][j] + uniquePathMatrix[i][j - 1];
            }
        }
        return uniquePathMatrix[m -1][n-1];
    }
}
