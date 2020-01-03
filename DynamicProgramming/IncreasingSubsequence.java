package DynamicProgramming;

import java.util.Arrays;

public class IncreasingSubsequence
{
    public static void main(String args[]){
        int[] arr = {1, 5, 3, 2, 2, 10, 12, 15};
        System.out.println(new IncreasingSubsequence().increasingSubsequence(arr));
        System.out.println(new IncreasingSubsequence().increasingSubsequence1(arr));
    }

    private int increasingSubsequence(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < arr.length; i++){
            int currLen = dp[i];
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    currLen = Math.max(currLen, dp[j] + 1);
                }
            }

            dp[i] = currLen;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    private int increasingSubsequence1(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];

        int len = 0;
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);
            if(index < 0){
                index = - (index + 1);
            }
            dp[index] = num;
            if(index == len){
                len++;
            }
        }
        return len;
    }
}
