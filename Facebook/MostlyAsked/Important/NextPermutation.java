package Facebook.MostlyAsked.Important;

import java.util.Arrays;

public class NextPermutation
{
    public static void main(String args[]){
        int nums[] = {1, 5, 1};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void nextPermutation(int[] nums)
    {
        if(nums == null || nums.length == 0) return;

        int n = nums.length;
        int i = n - 1;

        for(; i > 0; i--){
            if(nums[i] <= nums[i - 1]) continue;
            break;
        }

        i = i - 1;
        if(i >= 0) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] >= nums[j]) continue;
                else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }

        for(int k = i + 1, j = n - 1; k < j; k++, j--){
            int temp = nums[k];
            nums[k] = nums[j];
            nums[j] = temp;
        }
    }

    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
