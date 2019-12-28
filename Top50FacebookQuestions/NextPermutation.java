/*
https://leetcode.com/problems/next-permutation/
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
package Top50FacebookQuestions;

import java.util.Arrays;

public class NextPermutation
{
    public static void main(String args[]){
        int[] nums = {1, 5, 1};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        int i = n - 1;
        for(; i > 0; i--){
            if(nums[i - 1] >= nums[i]) continue;
            break;
        }

        i = i - 1;

        if(i >= 0){
           for(int j = n -1; j > i; j--){
               if(nums[i] >= nums[j]){
                   continue;
               }
               swap(nums, i, j);
               break;
           }
        }
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
