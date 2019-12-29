/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
package Top50FacebookQuestions;

import java.util.PriorityQueue;

public class KthLargestElementAnArray
{
    public static void main(String args[]){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        KthLargestElementAnArray kth = new KthLargestElementAnArray();
        System.out.println(kth.findKthLargest(nums, k));
    }

    public int findKthLargest1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : nums){
            queue.add(i);
            if(queue.size() > k){
                queue.remove();
            }
        }

        return queue.poll();
    }

    public int findKthLargest(int[] nums, int k){
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k){
        int pivot = nums[start];
        int l = start + 1;
        int r = end;
        while (l <= r){
            while(l <= r && nums[l] <= pivot) l++;
            while (l <= r && nums[r] > pivot) r--;
            if(l > r) break;
            swap(nums, l, r);
        }
        swap(nums, start, r);

        if(r == k) return nums[r];

        if(r > k){
            return findKthLargest(nums, start, r - 1, k);
        }else{
            return findKthLargest(nums, r + 1, end, k);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
