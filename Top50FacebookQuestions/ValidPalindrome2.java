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
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
package Top50FacebookQuestions;

public class ValidPalindrome2
{
    public static void main(String args[]){
        String s = "abbca";
        ValidPalindrome2 v = new ValidPalindrome2();
        System.out.println(v.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                continue;
            }else{
                return checkPalindrom(s, i + 1, j) || checkPalindrom(s, i, j - 1);
            }
        }
        return true;
    }

    public boolean checkPalindrom(String s, int i, int j)
    {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
