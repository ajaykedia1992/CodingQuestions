/*
https://leetcode.com/problems/remove-invalid-parentheses/
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis
{
    public static void main(String args[])
    {
        String s = "()())()";
        RemoveInvalidParenthesis r = new RemoveInvalidParenthesis();
        List<String> res = r.removeInvalidParentheses(s);
        System.out.println(res);
    }

    public List<String> removeInvalidParentheses(String s)
    {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        helper(new StringBuilder(s), 0, 0, '(', ')', res);
        return res;
    }
    public void helper(StringBuilder s, int left, int right, char open, char close, List<String> res){
        int numberOfBracket = 0;

        for(int i = left; i < s.length(); i++){
            if(s.charAt(i) == open) numberOfBracket++;
            if(s.charAt(i) == close) {
                numberOfBracket--;
                if(numberOfBracket < 0){
                    for(int j = right; j <= i; j++){
                        if(s.charAt(j) == close && (j == right || s.charAt(j) != s.charAt(j - 1))){
                            helper(s.deleteCharAt(j), i, j, open, close, res);
                            s.insert(j, close);
                        }
                    }
                    return;
                }
            }

        }

        s.reverse();
        if(open == '('){
            helper(s, 0,0, ')', '(', res);
        }else{
            res.add(s.toString());
        }
        s.reverse();
    }

}
