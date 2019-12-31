/*
https://leetcode.com/problems/expression-add-operators/
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
(not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators
{
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;

        dfs(res, 0, 0, 0, "", num, target);
        return res;
    }

    public void dfs(List<String> res, int index, long bufvalue, long sum, String path, String num, int target){
        if(index == num.length()){
            if(sum + bufvalue == target){
                res.add(path);
            }
            return;
        }

        for(int i = index; i < num.length(); i++){

            // 0 + ....  but not this one 08 + ....
            if(i != index && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1));

            if(index == 0){
                dfs(res, i + 1, curr, sum, path + curr, num, target);
            }else{
                dfs(res, i + 1, curr, sum + bufvalue, path + "+" + curr, num, target);
                dfs(res, i + 1, -curr, sum + bufvalue, path + "-" + curr, num, target);
                dfs(res, i + 1, curr * bufvalue, sum, path + "*" + curr, num, target);
            }
        }
    }

    public static void main(String args[]){
        String num = "105";
        System.out.println(new ExpressionAddOperators().addOperators(num, 5));
    }
}
