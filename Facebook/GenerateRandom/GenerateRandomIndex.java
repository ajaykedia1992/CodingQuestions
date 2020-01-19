package Facebook.GenerateRandom;

import java.util.Random;

public class GenerateRandomIndex
{
    public static void main(String args[]){
        int[] nums = {1, 3, 2, 1, 2, 3, 3};
        System.out.println(new GenerateRandomIndex().randomIndexPick(nums));
        System.out.println(new GenerateRandomIndex().randomIndexPick(nums));
        System.out.println(new GenerateRandomIndex().randomIndexPick(nums));
        System.out.println(new GenerateRandomIndex().randomIndexPick(nums));
    }

    private int randomIndexPick(int[] nums)
    {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int maxIndex = -1;

        int count = 0;
        Random random = new Random();
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(maxValue < nums[i]){
                maxValue = nums[i];
                count = 1;
                maxIndex = i;
            }
            else if(maxValue == nums[i]){
                count++;
                if(random.nextInt(count) == 0){
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}
