/*
https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
Return the result as a list of indices representing the starting position of each interval (0-indexed).
If there are multiple answers, return the lexicographically smallest one.
Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:
1. nums.length will be between 1 and 20000.
2. nums[i] will be between 1 and 65535.
3. k will be between 1 and floor(nums.length / 3).
 */
package Top50FacebookQuestions;

import java.util.Arrays;

public class MaximumSumOf3NonOverlapping
{
    public static void main(String args[]){
        int[] nums = {1,2,1,2,6,7,5,1};
        int k = 2;
        MaximumSumOf3NonOverlapping m = new MaximumSumOf3NonOverlapping();
        System.out.println(Arrays.toString(m.maxSumOfThreeSubarrays(nums, k)));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};

        if(k <= 0) return new int[]{};

        int n = nums.length;
        int len = n - k + 1;
        int[] presum = new int[len];
        int[] left  = new int[len];
        int[] right = new int[len];

        presumFilling(nums, k, presum, len);
        leftRightMaxIndex(presum, left, right, len);
        int[] res = new int[3];
        Arrays.fill(res, -1);
        findMax(presum, left, right, res, k, len);
        return res;
    }

    public void presumFilling(int[] nums, int k, int[] presum, int len){
        for(int i = 0; i < k; i++){
            presum[0] += nums[i];
        }

        for(int i = 1; i < len; i++){
            presum[i] = presum[i - 1] + nums[i + k - 1] - nums[i - 1];
        }
    }

    public void leftRightMaxIndex(int[] presum, int[] left, int[] right, int len){
        int maxIndex = 0;
        for(int i = 0; i < len; i++){
            if(presum[i] > presum[maxIndex]){
                maxIndex = i;
            }
            left[i] = maxIndex;
        }

        maxIndex = len - 1;

        for(int i = len - 1; i >= 0; i--){
            if(presum[i] >= presum[maxIndex]){
                maxIndex = i;
            }
            right[i] = maxIndex;
        }
    }

    public void findMax(int[] presum, int[] left, int[] right, int[] res, int k, int len){
        for(int i = k; i < len - k; i++){
            if(res[0] == -1 || presum[res[0]] + presum[res[1]] + presum[res[2]] < presum[left[i - k]] + presum[i] + presum[right[i + k]]){
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }
    }
}
