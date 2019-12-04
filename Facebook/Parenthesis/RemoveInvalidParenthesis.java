package Facebook.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis
{
    public static void main(String args[]){
        RemoveInvalidParenthesis r = new RemoveInvalidParenthesis();
        System.out.println(r.removeInvalidParentheses("()())()"));
    }

    private List<String> removeInvalidParentheses(String s)
    {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);
        helper(res, str, 0, 0, '(', ')');
        return res;
    }

    private void helper(List<String> res, StringBuilder str, int left, int right, char open, char closed)
    {
        int numberBracket = 0;
        for(int  i = left; i < str.length(); i++){
            if(str.charAt(i) == open) numberBracket++;
            if(str.charAt(i) == closed) numberBracket--;
            if(numberBracket < 0){
                for(int j = right; j <= i; j++){
                    if(str.charAt(j)==closed && (j == right || str.charAt(j - 1) != closed)){
                        helper(res, str.deleteCharAt(j), i, j, open, closed);
                        str.insert(j, closed);
                    }
                }
                return;
            }
        }
        str.reverse();
        if(open == '('){
            helper(res, str, 0, 0, ')', '(');
        }else{
            res.add(str.toString());
        }
        str.reverse();
    }
}
