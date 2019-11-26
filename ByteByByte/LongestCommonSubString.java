package ByteByByte;

public class LongestCommonSubString
{
    public static void main(String args[]){
        String first = "ABABA";
        String second = "BABA";
        String common = LongestCommonSubString.getLongestCommonSubstring(first, second);
        System.out.println(common);
    }

    private static String getLongestCommonSubstring(String first, String second)
    {
        if(first == null || second == null){
            return null;
        }
        if((first.length() == 0 && second.length() != 0) || (first.length() != 0 && second.length() == 0)){
            return null;
        }

        int[][] matrix = new int[first.length()][second.length()];

        return getLongestCommonSubstringUtil(first, second, matrix);

    }

    private static String getLongestCommonSubstringUtil(String first, String second, int[][] matrix)
    {
        String output = "";
        for(int i = 0; i < first.length(); i++){
            for(int j = 0; j < second.length(); j++){
                if(first.charAt(i) == second.charAt(j)){
                    if(i == 0 || j == 0){
                        matrix[i][j] = 1;
                    }else{
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if(output.length() < matrix[i][j]){
                        output = first.substring(i - matrix[i][j] + 1, i + 1);
                    }
                }
            }
        }

        return output;
    }
}
