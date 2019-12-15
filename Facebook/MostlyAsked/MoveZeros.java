package Facebook.MostlyAsked;

import java.util.Arrays;

public class MoveZeros
{
    public static void main(String args[]){
        int[] nums = {0, 1, 0, 2, 3, 0, 5};
        MoveZeros m = new MoveZeros();
        m.moveZeros(nums);
        System.out.print(Arrays.toString(nums));
    }

    private void moveZeros(int[] nums)
    {
        if(nums == null || nums.length == 0){
            return;
        }
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }

        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
