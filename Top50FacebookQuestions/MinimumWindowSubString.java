/*
https://leetcode.com/problems/minimum-window-substring/
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
package Top50FacebookQuestions;


public class MinimumWindowSubString
{
    public static void main(String args[]){
        String S = "ADOBECODEBANC";
        String T = "ABC";

        MinimumWindowSubString m = new MinimumWindowSubString();
        String res = m.minWindow(S, T);
        System.out.println(res);
    }

    public String minWindow(String s, String t){
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return  "";
        if(t.length() > s.length()) return "";

        int[] bank = new int[256];
        int right = 0, left = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        String minString = "";

        for(char c : t.toCharArray()){
            bank[c]++;
        }

        while(right < s.length()){
            if(bank[s.charAt(right++)]-- > 0){
                count++;
                while(count == t.length()){
                    if(minLength > (right - left)){
                        minLength = right - left;
                        minString = s.substring(left, right);
                    }

                    if(bank[s.charAt(left++)]++ == 0){
                        count--;
                    }
                }
            }
        }
        return minString;
    }
}
