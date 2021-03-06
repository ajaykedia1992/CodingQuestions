/*
Given a list of non-negative numbers and a target integer k,
write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 */
package Facebook.Continuous;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArray1
{
    public static void main(String args[]){
        int arr[] = {23, 2, 4, 6, 7};
        int k = 6;
        ContinuousSubArray1 c = new ContinuousSubArray1();
        System.out.println(c.checkSubarraySum(arr, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0 , -1);

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            int remaining = k == 0 ? sum : sum % k;

            if(map.containsKey(remaining) && i - map.get(remaining) >= 2){
                return true;
            }

            map.putIfAbsent(remaining , i);
        }
        return false;
    }
}
