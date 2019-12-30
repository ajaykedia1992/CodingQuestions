/*
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */
package Top50FacebookQuestions;

public class LongestSubStringWithAtMostKCharacter
{
    public static void main(String args[]){
        String s = "eceba";
        int k = 2;
        LongestSubStringWithAtMostKCharacter l = new LongestSubStringWithAtMostKCharacter();
        System.out.println(l.lengthOfLongestSubstringKDistinct(s, k));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        if(k <= 0) return 0;
        if(k >= s.length()) return s.length();

        int right = 0, left = 0;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        int[] bank = new int[256];

        while(right < s.length()){
            if(bank[s.charAt(right++)]++ == 0){
                count++;
            }
            if(count > k){
                if(--bank[s.charAt(left++)] == 0) count--;
            }
            if(right - left > maxLength){
                maxLength = right - left;
            }
        }
        return maxLength;
    }
}
