/*
https://leetcode.com/problems/remove-invalid-parentheses/
 */
package Facebook.PreviousInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParanthesis
{
    public static void main(String args[]){
        RemoveInvalidParanthesis r = new RemoveInvalidParanthesis();
        System.out.println(r.removeInvalidParanthesis("()())()"));
    }

    private List<String> removeInvalidParanthesis(String s)
    {
        List<String> res = new LinkedList<>();

        removeInvalidParanthesisUtil(new StringBuilder(s), res, '(', ')', 0, 0);

        return res;

    }

    private void removeInvalidParanthesisUtil(StringBuilder s, List<String> res, char open, char close, int left, int right)
    {
        int numberOfBracket = 0;
        for(int i = left; i < s.length(); i++){
            if(s.charAt(i) == open) numberOfBracket++;
            if(s.charAt(i) == close) numberOfBracket--;
            if(numberOfBracket < 0){
                for(int j = right; j <= i; j++){
                    if(s.charAt(j) == close && (j == right || s.charAt(j) != s.charAt(j - 1))) {
                        removeInvalidParanthesisUtil(s.deleteCharAt(j), res, open, close, i, j);
                        s.insert(j, close);
                    }
                }
                return ;
            }
        }

        s.reverse();
        if(open == '('){
            removeInvalidParanthesisUtil(s, res, ')', '(', 0, 0);
        }else{
            res.add(s.toString());
        }
        s.reverse();
    }
}
