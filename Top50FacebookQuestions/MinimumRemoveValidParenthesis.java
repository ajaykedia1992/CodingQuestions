/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:
Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
Constraints:
1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 */
package Top50FacebookQuestions;

public class MinimumRemoveValidParenthesis
{
    public String minRemoveToMakeValid(String s) {
        int numOfBracket = 0;
        int openSeen = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                numOfBracket++;
                openSeen++;
            }
            if(c == ')') numOfBracket--;
            if(numOfBracket < 0){
                numOfBracket = 0;
                continue;
            }
            sb.append(c);
        }

        int openBracket = openSeen - numOfBracket;

        StringBuilder res = new StringBuilder();
        for(char c : sb.toString().toCharArray()){
            if(c == '('){
                if(openBracket <= 0){
                    continue;
                }
                openBracket--;
            }
            res.append(c);
        }
        return res.toString();
    }
}
