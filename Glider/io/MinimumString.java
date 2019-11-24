package Glider.io;

public class MinimumString
{
    public static void main(String args[]){
        String str1 = "AATAAT";
        String str2 = "TTT";
        int n = str1.length();
        int m = str2.length();
        System.out.println(solve(str1, str2, n, m));
    }

    public static int solve(String str1, String str2, int n, int m) {
        if(str1.length() < str2.length())
        {
            return solve(str2, str1, m, n);
        }
        // str1 - bigger
        int[][] matrix = new int[m + 1][n + 1];
        for(int i = 0; i < matrix[0].length; i++){
            matrix[0][i] = i;
        }

        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = i;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                try {
                    if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    else {
                        matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + 1;
                    }
                }catch (Exception e){
                    System.out.println(i + ", " + j);
                }
            }
        }

        return matrix[m][n];
    }
}
