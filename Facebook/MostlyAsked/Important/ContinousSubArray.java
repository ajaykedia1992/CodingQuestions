/*
https://leetcode.com/problems/maximum-subarray/
 */
package Facebook.MostlyAsked.Important;

public class ContinousSubArray
{
    public static void main(String args[]){
        int arr[] = {-1, 3, 4, -6, 2, 5, -1};
        ContinousSubArray c = new ContinousSubArray();
        System.out.println(c.getContinuousSubArray(arr));
    }

    private int getContinuousSubArray(int[] arr)
    {
        int runningValue = 0;
        int maxValue = Integer.MIN_VALUE;

        for(int i : arr){
            runningValue += i;

            if(runningValue > maxValue){
                maxValue = runningValue;
            }
            if(runningValue < 0){
                runningValue = 0;
            }
        }
        return maxValue;
    }

    public int getContinuousSubArray1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] temp = new int[nums.length];

        temp[0] = nums[0];
        int maxValue = temp[0];
        for(int i = 1; i < nums.length; i++){
            temp[i] = Math.max(nums[i], nums[i] + temp[i - 1]);
            maxValue = Math.max(maxValue, temp[i]);
        }
        return maxValue;
    }
}
