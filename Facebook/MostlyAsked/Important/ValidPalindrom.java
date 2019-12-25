/*
https://leetcode.com/problems/valid-palindrome-ii/
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
 */
package Facebook.MostlyAsked.Important;

public class ValidPalindrom
{
    public static void main(String args[]){
        String str = "abc";
        ValidPalindrom v = new ValidPalindrom();
        System.out.println(v.validPalindrome(str));
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;

        int n = s.length();

        int i = 0;
        int j = n - 1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                if(checkPalindrom(s, i + 1, j) || checkPalindrom(s, i, j - 1)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean checkPalindrom(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
