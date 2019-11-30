/*
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
package Coderpad.io;

public class MinimumSubArrayLength
{
    public static void main(String args[]){
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        MinimumSubArrayLength m = new MinimumSubArrayLength();
        System.out.println(m.getMinimumSubArrayLength(s, nums));
    }

    private int getMinimumSubArrayLength(int s, int[] nums)
    {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int right = 0;
        int left = 0;
        int n = nums.length;
        int minLength = n  + 1;
        while(right < n){
            s -= nums[right++];
            while(s <= 0){
                if(left < n){
                    minLength = Math.min(minLength, right - left);
                    s += nums[left++];
                }
            }
        }
        return minLength % (n + 1);

    }
}
