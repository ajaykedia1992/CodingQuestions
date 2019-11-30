/*
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */
package Coderpad.io.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        combinationSum2(candidates, target, res, temp, 0);
        return res;
    }

    public void combinationSum2(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;

            temp.add(candidates[i]);
            combinationSum2(candidates, target-candidates[i], res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String args[]){
        int[] arr = {1, 3, 5, 7, 8};
        int target = 8;
        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> result = c.combinationSum2(arr, target);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
}
