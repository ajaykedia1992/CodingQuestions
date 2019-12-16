/*
Given an array of integers arr, randomly return an index of the maximum value seen by far.

Example:
Input: [11, 30, 2, 30, 30, 30, 6, 2, 62, 62]

Having iterated up to the at element index 5 (where the last 30 is), randomly give an index among [1, 3, 4, 5] which are indices of 30 - the max value by far. Each index should have a ¼ chance to get picked.
Having iterated through the entire array, randomly give an index between 8 and 9 which are indices of the max value 62.
 */

package Facebook.MostlyAsked;

import java.util.Random;

public class GenerateRandomIndex
{
    public static void main(String args[]){
        int[] arr = {11, 30, 2, 30, 30, 30, 6, 2, 62, 62};
        GenerateRandomIndex g = new GenerateRandomIndex();
        //g.sampleIdx(arr);
        //g.sampleIdx(arr);
        //g.sampleIdx(arr);
        System.out.println(g.maxRandomIndex(arr));
        System.out.println(g.maxRandomIndex(arr));
        System.out.println(g.maxRandomIndex(arr));
    }

    public void sampleIdx(int[] array){
        if(array == null || array.length == 0){
            return;
        }
        Random rnd = new Random();
        int res = 0, max = Integer.MIN_VALUE, count = 0;
        for(int i = 0; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
                res = i;
                count = 1;
            }else if(max == array[i]){
                count++;
                int idx = rnd.nextInt(count); //(0, k - 1)
                if(idx == 0){

                    res = i;
                    System.out.println("A max value index up to the " +i +"th element is " + res);

                }
            }
        }
    }


    public int maxRandomIndex(int[] nums) {
        Random random = new Random();
        int maxIndex = 0;

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
                count = 1;
            } else if (nums[i] == nums[maxIndex]) {
                count++;

                // probability of 1/count
                if (random.nextInt(count) == 0) {
                    maxIndex = i;
                }
            }
        }

        return maxIndex;
    }
}
