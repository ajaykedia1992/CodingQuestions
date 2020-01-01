package Facebook;

public class QuickSelect
{
    public static void main(String args[]){
        int[] arr = {1, 3, 4,2};
        int k = 1;
        QuickSelect q = new QuickSelect();
        System.out.println(q.kthLargestElement(1, arr));
    }

    public int kthLargestElement(int n, int[] nums) {

        int start = 0; int end = nums.length - 1;

        return quickSort(nums, start, end, nums.length - n);

    }

    public int quickSort(int[] nums, int start, int end, int k){

        int pivot = nums[start];
        int left = start + 1;
        int right = end;

        while(left < right){
            while(left < nums.length && nums[left] < pivot){
                left++;
            }
            while(right >= left && nums[right] > pivot){
                right--;
            }

            if(left > right) break;
            swap(nums, left, right);
        }

        swap(nums, start, right);

        if(k == right){
            return nums[right];
        }

        else if(right < k){
            return quickSort(nums, right + 1, end, k);
        }
        return  quickSort(nums, start, right - 1, k);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
