/*
Given an array of integers arr, randomly return an index of the maximum value seen by far.

Example:
Input: [11, 30, 2, 30, 30, 30, 6, 2, 62, 62]

Having iterated up to the at element index 5 (where the last 30 is), randomly give an index among [1, 3, 4, 5]
which are indices of 30 - the max value by far. Each index should have a ¼ chance to get picked.
Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.
https://leetcode.com/discuss/interview-question/451431/
 */

package Facebook.PreviousInterviews.FacebookPremium;

import java.util.Random;

public class GenerateRandomMaxIndex
{
    public static void main(String args[]){
        int[] nums = {11, 30, 2, 30, 30, 30, 6, 2, 62, 62};
        GenerateRandomMaxIndex g = new GenerateRandomMaxIndex();
        System.out.println(g.getMaxIndex(nums));
        System.out.println(g.getMaxIndex(nums));
        System.out.println(g.getMaxIndex(nums));
        System.out.println(g.getMaxIndex(nums));

    }

    private int getMaxIndex(int[] nums)
    {
        Random random = new Random();
        int maxIndex = -1;
        int maxNumber = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxNumber < nums[i]){
                maxIndex = i;
                maxNumber = nums[i];
                count = 1;
            }
            else if(maxNumber == nums[i]){
                count++;
                if(random.nextInt(count) == 0){
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}
