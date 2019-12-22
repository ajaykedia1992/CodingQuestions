/*
https://leetcode.com/problems/subarray-sum-equals-k/
 */
package Facebook.PreviousInterviews;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualToK
{
    public static void main(String args[]){
        int[] arr = {1, 1, 1};
        int k = 2;

        SubarraySumEqualToK s = new SubarraySumEqualToK();
        System.out.println(s.subArraySumEqualToK(arr, k));
    }

    private int subArraySumEqualToK(int[] arr, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , 1);

        int sum = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
