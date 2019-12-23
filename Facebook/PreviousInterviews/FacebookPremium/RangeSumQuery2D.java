/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
package Facebook.PreviousInterviews.FacebookPremium;

public class RangeSumQuery2D
{
    public static void main(String args[]){
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        RangeSumQuery2D r = new RangeSumQuery2D();
        r.numMatrix(matrix);
        System.out.println(r.sumRegion(2, 1, 4, 3));
        System.out.println(r.sumRegion(1, 1, 2, 2));
        System.out.println(r.sumRegion(1, 2, 2, 4));
    }

    int[][] dp;
    public void numMatrix(int[][] matrix){
        if(matrix == null || matrix.length == 0) return;

        dp = new int[matrix.length + 1][matrix[0].length + 1];

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                dp[row + 1][col + 1] = dp[row + 1][col] + dp[row][col + 1] + matrix[row][col] - dp[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

}
