/*
Max sum of M non-overlapping subarrays of size K
https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
Input: N = 7, M = 3, K = 1
       arr[] = {2, 10, 7, 18, 5, 33, 0};
Output: 61
Explanation: subsets are: 33, 18, 10 (3 subsets of size 1)
 */

package Facebook.OverlappingSubArrays;

import java.util.Arrays;

public class OverlappingSubArrays
{
    public static void main(String args[]){
        int[] arr = {2, 10, 7, 18, 5, 33, 0};
        int M = 3;
        int K = 2;
        OverlappingSubArrays o = new OverlappingSubArrays();

        int maxSum = o.getOverlappingMaxSubArraysValue(arr, M, K);
        System.out.println(maxSum);
    }

    private int getOverlappingMaxSubArraysValue(int[] arr, int M, int K)
    {
     // first we will create the presum arrays, where each index will have the value of the numbers of size K
        int n = arr.length;
        int len = n - K + 1;
        int[] preSum  = new int[len];
        calculatePresum(preSum, arr, len, K);
        System.out.println(Arrays.toString(preSum));
        return maxOverlappingSubArrays(preSum, M, len, K, 0);
    }

    private void calculatePresum(int[] preSum, int[] arr, int len, int K)
    {
        for(int i = 0; i < K; i++){
            preSum[0] += arr[i];
        }
        for(int i = 1; i < len; i++){
            preSum[i] = preSum[i - 1] + arr[i + K - 1] - arr[i - 1];
        }
    }
    private int maxOverlappingSubArrays(int[] preSum, int m, int len, int K, int start)
    {
        if(m == 0) return 0;

        if(start > len - 1){
            return 0;
        }

        int includeMaxSum = preSum[start] + maxOverlappingSubArrays(preSum, m - 1, len, K, start + K);

        int exludeSum = maxOverlappingSubArrays(preSum, m, len, K, start + 1);

        return Math.max(includeMaxSum, exludeSum);
    }

}
