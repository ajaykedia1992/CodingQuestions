/*
https://leetcode.com/problems/valid-palindrome/
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
package Top50FacebookQuestions;

public class ValidPalindrome
{
    public static void main(String args[]){
        String s = "race a car";
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;

        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)){
                if(c1 == c2){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
            else if(!Character.isLetterOrDigit(c1) && !Character.isLetterOrDigit(c2)){
                i++;
                j--;
            }
            else if(!Character.isLetterOrDigit(c1)){
                i++;
            }

            else if(!Character.isLetterOrDigit(c2)){
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
