/*
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
package Coderpad.io.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3
{
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        combinationSum3(k, n, temp, res, 1);
        return res;
    }
    public void combinationSum3(int k, int target, List<Integer> temp, List<List<Integer>> res, int start){
        if(target < 0) return;

        if(target == 0){
            if(temp.size() == k)
                res.add(new ArrayList<>(temp));
            return;
        }
        if(start > target || temp.size() > k) return;
        for(int i = start; i <= 9; i++){
            temp.add(i);
            combinationSum3(k, target - i,  temp, res, i + 1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String args[]){
        int k = 3;
        int n = 9;
        CombinationSum3 c = new CombinationSum3();
        List<List<Integer>> result = c.combinationSum3(k , n);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
}
