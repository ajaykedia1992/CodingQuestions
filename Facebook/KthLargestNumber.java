package Facebook;

public class KthLargestNumber
{
    public static void main(String args[]){
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        KthLargestNumber kth = new KthLargestNumber();
        System.out.println(kth.findKthLargest(arr, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(k > nums.length){
            throw new IllegalArgumentException();
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int start, int end, int k){

        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while(l <= r){
            while(l <= r && nums[l] <= pivot){
                l++;
            }
            while(l <= r && nums[r] > pivot){
                r--;
            }
            if(l > r) break;
            swap(nums, l, r);
        }

        swap(nums, start, r);

        if(r == k){
            return pivot;
        }
        else if(r > k){
            return quickSelect(nums, start, r - 1, k);
        }else{
            return quickSelect(nums, r + 1, end, k);
        }
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
