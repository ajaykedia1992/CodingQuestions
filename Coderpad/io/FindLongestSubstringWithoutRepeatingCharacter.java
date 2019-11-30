package Coderpad.io;

public class FindLongestSubstringWithoutRepeatingCharacter
{
    public static void main(String args[]){
        String s = "abcabcbebda";
        System.out.println(findLongestSubstringWithoutRepeatingCharacter(s));
    }

    private static int findLongestSubstringWithoutRepeatingCharacter(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] bank = new int[255];
        int right = 0, left = 0;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        while(right < s.length()){
            if(bank[s.charAt(right++)]++ > 0){
                count++;
            }
            while(count > 0){
                if(--bank[s.charAt(left++)] > 0){
                    count--;
                }
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
