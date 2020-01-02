package Facebook.LintCode.Parenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis
{
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return  res;
        generateParenthesis(n, res, "", 0, 0);
        return res;
    }

    public void generateParenthesis(int n, List<String> res, String path, int left, int right){
        if(path.length() == 2 * n){
            res.add(path);
            return;
        }

        if(left < n){
            generateParenthesis(n, res, path + '(', left + 1, right);
        }
        if(right < left){
            generateParenthesis(n, res, path + ')', left, right + 1);
        }
    }
}
