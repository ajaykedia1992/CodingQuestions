/*
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */
package Facebook.CombinationSum;

import java.util.Arrays;

public class CombinationSum4
{
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        int result = combinationSum4(nums, target, memo);
        return result;
    }

    public int combinationSum4(int[] nums, int target, int[] memo){
        if(target < 0) return 0;
        if(memo[target] != -1){
            return memo[target];
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += combinationSum4(nums, target-nums[i], memo);
        }
        memo[target] = res;
        return res;
    }

    public static void main(String args[]){
        int[] nums = {1, 2, 3};
        int target = 2;
        CombinationSum4 c = new CombinationSum4();
        System.out.println(c.combinationSum4(nums, target));
    }
}
