package Coderpad.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutation
{

    public static void main(String args[])
    {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = new UniquePermutation().permuteUnique(nums);
        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteUniqueUtil(nums, res, temp, used);
        return res;
    }

    public void permuteUniqueUtil(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] used)
    {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            permuteUniqueUtil(nums, result, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }

    }
}
