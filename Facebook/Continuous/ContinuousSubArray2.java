/*
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
 */
package Facebook.Continuous;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArray2
{
    public static void main(String args[])
    {
        int[] arr = {1, 1, 1};
        int k = 2;
        ContinuousSubArray2 c = new ContinuousSubArray2();
        System.out.println(c.subarraySum(arr, k));

    }

    private int subarraySum(int[] arr, int k)
    {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : arr) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
