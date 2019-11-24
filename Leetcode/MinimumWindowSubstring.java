package Leetcode;

public class MinimumWindowSubstring {
    public static void main(String args[]) {
        String str = "DCBBAMC";
        String t = "AC";

        System.out.println(findMinimumWindowSubString(str, t));
    }

    private static String findMinimumWindowSubString(String str, String t) {
        int[]bank = new int[256];
        int count = 0;
        int left = 0, right = 0;
        int minimumWindow = Integer.MAX_VALUE;
        String result = "";
        for(int i = 0; i<t.length(); i++){
            ++bank[t.charAt(i)];
        }

        while(right<str.length()){
            if(bank[str.charAt(right++)]-- > 0){
                count++;
            }
            while(count == t.length()){
                if(minimumWindow > (right - left)){
                    minimumWindow = right - left;
                    result = str.substring(left, right);
                }

                if(++bank[str.charAt(left++)] > 0){
                    count--;
                }
            }
        }
        return result;
    }
}
