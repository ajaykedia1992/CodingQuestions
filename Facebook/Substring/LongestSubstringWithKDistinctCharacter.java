package Facebook.Substring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacter
{

    public static void main(String args[]){
        LongestSubstringWithKDistinctCharacter l = new LongestSubstringWithKDistinctCharacter();
        String str = "eceba";
        int k = 2;
        System.out.println(l.lengthOfLongestSubstringKDistinct(str, k));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        if(k <= 0) return 0;

        if(k >= s.length()) return s.length();

        int start = 0;
        int end = 0;
        int maxLength = Integer.MIN_VALUE;
        int[] bank = new int[256];
        int total = 0;
        while(end < s.length()){
            if(bank[s.charAt(end++)]++ == 0){
                total++;
            }
            if(total > k){
                if(--bank[s.charAt(start++)] == 0){
                    total--;
                }
            }

            maxLength = Math.max(maxLength, end - start);

        }
        return maxLength;
    }
}
