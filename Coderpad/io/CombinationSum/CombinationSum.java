/*
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
package Coderpad.io.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSumUtil(candidates, target, result, temp, 0, 0);

        return result;
    }

    public void combinationSumUtil(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp,
                                   int sum, int curr) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = curr; i < candidates.length; i++) {
            temp.add(candidates[i]);
            combinationSumUtil(candidates, target, result, temp, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }

    }
    public static void main(String args[]){
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum c = new CombinationSum();
        List<List<Integer>> result = c.combinationSum(candidates, target);
        for (List<Integer> r : result){
            System.out.println(r);
        }
    }
}
