package Facebook.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis
{
    public static void main(String args[]){
        int n = 2;
        GenerateParenthesis g = new GenerateParenthesis();

        System.out.println(g.getAllBalancedParenthesis(n));
    }

    private List<String> getAllBalancedParenthesis(int n)
    {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }

    private void helper(List<String> res, String prefix, int left, int right)
    {
        if(left < 0 || left > right){
            return ;
        }
        if(left == 0 && right  == 0){
            res.add(prefix);
            return;
        }
        helper(res, prefix + "(", left - 1, right);
        helper(res, prefix + ")", left, right - 1);
    }
}
