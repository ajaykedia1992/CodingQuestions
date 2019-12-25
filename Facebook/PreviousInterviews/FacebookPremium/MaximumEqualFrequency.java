/*
Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this
prefix so that every number that has appeared in it will have the same number of occurrences.
If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).
Example 1:

Input: nums = [2,2,1,1,5,3,3,5]
Output: 7
Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.

https://leetcode.com/problems/maximum-equal-frequency/

Constraints:

2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
 */
package Facebook.PreviousInterviews.FacebookPremium;

public class MaximumEqualFrequency
{
    public static void main(String args[])
    {
        MaximumEqualFrequency m = new MaximumEqualFrequency();
        int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        System.out.println(m.maxEqualFreq(nums));
    }

    private int maxEqualFreq(int[] nums)
    {
        int[] count = new int[100001];
        int[] frequency = new int[100001];
        int n = nums.length;
        for (int i = 0; i < n; i++){
            count[nums[i]]++;
            frequency[count[nums[i]]]++;
        }

        for(int i = n - 1; i > 0; i--){
            if(frequency[count[nums[i]]] * count[nums[i]] == i){
                return i + 1;
            }
            frequency[count[nums[i]]]--;
            count[nums[i]]--;
            if(frequency[count[nums[i - 1]]] * count[nums[i - 1]] == i){
                return i + 1;
            }
        }
        return 1;
    }
}
