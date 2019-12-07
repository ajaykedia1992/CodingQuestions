/*
https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/

Maximum Sum of 3 Non-Overlapping Subarrays
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
Note:

nums.length will be between 1 and 20000.
nums[i] will be between 1 and 65535.
k will be between 1 and floor(nums.length / 3).
 */
package Facebook.OverlappingSubArrays;

import java.util.Arrays;

public class MaximumSumOfThreeNonOverlappingSubArrays
{
    public static void main(String args[]){
        int nums[] = {1,2,1,2,6,7,5,1};
        int K = 2;
        MaximumSumOfThreeNonOverlappingSubArrays m = new MaximumSumOfThreeNonOverlappingSubArrays();
        int[] res = m.maxSumOfThreeSubarrays(nums, K);
        System.out.println(Arrays.toString(res));
    }

    private int[] maxSumOfThreeSubarrays(int[] nums, int k)
    {
        int n = nums.length;
        int len = n - k + 1;

        int[] preSum = new int[len];

        calculatePreSum(preSum, nums, len, k);
        System.out.println(Arrays.toString(preSum));
        int[] leftIndex = new int[len];
        int[] rightIndex = new int[len];

        getMaxIndex(preSum, leftIndex, rightIndex, len);

        int[] res = new int[3];
        Arrays.fill(res, - 1);
        getMaxSumofThreeSubArrays(res, leftIndex, rightIndex, preSum, k, len);

        return res;
    }

    private void getMaxSumofThreeSubArrays(int[] res, int[] leftIndex, int[] rightIndex, int[] preSum, int k, int len)
    {
        for(int i = k; i < len - k; i++){
            if(res[0] == -1 || (preSum[res[0]] +preSum[res[1]] +preSum[res[2]] < preSum[leftIndex[i - k]]  + preSum[i] + preSum[rightIndex[i + k]])){
                res[0] = leftIndex[i - k];
                res[1] = i;
                res[2] = rightIndex[i + k];
            }
        }
    }

    private void getMaxIndex(int[] preSum, int[] leftIndex, int[] rightIndex, int len)
    {
        int maxIndex = 0;
        for(int i = 0; i < len; i++){
            if(preSum[i] > preSum[maxIndex]){
                maxIndex = i;
            }
            leftIndex[i] = maxIndex;
        }

        maxIndex = len - 1;
        for(int i = len - 1; i >= 0; i--){
            if(preSum[i] >= preSum[maxIndex]){
                maxIndex = i;
            }
            rightIndex[i] = maxIndex;
        }
    }

    private void calculatePreSum(int[] preSum, int[] nums, int len, int k)
    {
        for(int i = 0; i < k; i++){
            preSum[0] += nums[i];
        }

        for(int i = 1; i < len; i++){
            preSum[i] = preSum[i - 1] + nums[i + k - 1] - nums[i - 1];
        }
    }
}
