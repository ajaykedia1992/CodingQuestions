package Facebook;

public class InterleavingString
{
    public static void main(String args[]){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString i = new InterleavingString();
        System.out.println(i.isInterleave(s1, s2, s3));
    }

    private boolean isInterleave(String s1, String s2, String s3)
    {
        if(s1.length() + s2.length() != s3.length()) return false;
        return isInterleaveHelper(s1.toCharArray(), s2.toCharArray(), s3.toCharArray());
    }

    public boolean isInterleaveHelper(char[] c1, char[] c2, char[] c3) {
        boolean[][] dp = new boolean[c2.length + 1][c1.length + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                int l = i + j - 1;
                if(i ==0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = c1[j - 1] == c3[l] ? dp[i][j - 1] : false;
                }
                else if(j == 0){
                    dp[i][j] = c2[i - 1] == c3[l] ? dp[i - 1][j] : false;
                }
                else{
                    dp[i][j] = (c2[i-1] == c3[l] ? dp[i-1][j] : false) || (c1[j-1] == c3[l] ? dp[i][j-1] : false);
                }
            }
        }
        return dp[c2.length][c1.length];
    }

    public boolean isInterleaved(char str1[], char str2[], char str3[]){
        boolean T[][] = new boolean[str1.length +1][str2.length +1];

        if(str1.length + str2.length != str3.length){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length][str2.length];
    }
}
