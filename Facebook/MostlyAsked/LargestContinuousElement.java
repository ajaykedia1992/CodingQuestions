/*
https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 */
package Facebook.MostlyAsked;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LargestContinuousElement
{
    public static void main(String args[]){
        int[] arr = {1, 56, 58};

        System.out.println(new LargestContinuousElement().getLargestContinuousSubarray(arr));
    }

    private int getLargestContinuousSubarray(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxCount = 0;

        Set<Integer> set = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toSet()));

        for(int i : set){
            if(set.contains(i - 1)) continue;
            int count = 0;
            while(set.contains(i++)) count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
