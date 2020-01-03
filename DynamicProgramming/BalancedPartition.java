package DynamicProgramming;

/*
https://algorithmsandme.com/balanced-partition-problem/
Given a set of integers, partition those integers into two parts where the difference between the two parts is minimum.
This problem is known as balanced partition problem. For example, array A = {1,7,4,11},
two subsets can be: {1,11} and {7,4}, two have a difference of 1, which is the minimum difference we can get by splitting this array.
 */
public class BalancedPartition
{
    public static void main(String args[]){
        int arr[] = {3, 7, 4, 11};
        int minimum = new BalancedPartition().balancedPartition(arr);
        System.out.println(minimum);
    }

    private int balancedPartition(int[] nums)
    {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int S = 0;
        for(int i : nums){
            S += i;
        }
        int total = S / 2;
        boolean dp[][] = new boolean[n + 1][total + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = false;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //excluding value
                dp[i][j] = dp[i - 1][j];
                if(nums[i - 1] <= j){
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }


        int j = -1;
        for(int i = total; i >= 0; i--){
            if(dp[n][i]){
                j = i;
                break;
            }
        }

        return S - j * 2;
    }
}
