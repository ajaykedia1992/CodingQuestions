package Facebook;

public class RotatedSearchArray
{
    public static void main(String args[]){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        RotatedSearchArray r = new RotatedSearchArray();
        System.out.println(r.search(nums, target));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0, end = nums.length - 1;

        while(start <= end){
            int pivot = start + (end - start) / 2;
            if(nums[pivot] == target) return pivot;

            else if(nums[start] <= nums[pivot]){
                if(target >= nums[start] && target < nums[pivot]) {
                    end = pivot - 1;
                }else{
                    start = pivot + 1;
                }
            }else{
                if(target <= nums[end] && target > nums[pivot]){
                    start = pivot + 1;
                }else{
                    end = pivot - 1;
                }
            }
        }

        return -1;
    }
}
