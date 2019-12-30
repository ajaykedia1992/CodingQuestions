/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
package Top50FacebookQuestions;

import java.util.Arrays;

public class FirstAndLastPositionElement
{
    public static void main(String args[]){
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        FirstAndLastPositionElement fl = new FirstAndLastPositionElement();
        System.out.println(Arrays.toString(fl.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return res;

        int leftIndex = binarySearch(nums, target, true);
        if(leftIndex == nums.length || nums[leftIndex] != target){
            return res;
        }

        res[0] = leftIndex;
        res[1] = binarySearch(nums, target, false) - 1;
        return res;

    }

    public int binarySearch(int[] nums, int target, boolean isLeft){
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target || (isLeft && nums[mid] == target)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
