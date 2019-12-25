/*
https://leetcode.com/problems/sliding-window-maximum/
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */
package Facebook.SlidingWindow;

import java.util.Arrays;

public class SlidingWindowMaximum
{
    public static void main(String args[]){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] res = s.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private int[] maxSlidingWindow(int[] nums, int k)
    {
        if(nums == null || nums.length == 0) return new int[] {};

        if(k == 1) return nums;

        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for(int i = 1; i < n ; i++){
            if(i % k == 0) {
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i - 1],  nums[i]);
            }

            int j = n - i - 1;
            if((j + 1) % k == 0){
                right[j] = nums[j];
            }else{
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        int[] res = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}
