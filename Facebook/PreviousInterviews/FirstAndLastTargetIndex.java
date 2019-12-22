/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
package Facebook.PreviousInterviews;

import java.util.Arrays;

public class FirstAndLastTargetIndex
{
    public static void main(String args[]){
        int arr [] = {5, 7, 7, 8, 8, 10};
        FirstAndLastTargetIndex f = new FirstAndLastTargetIndex();
        System.out.println(Arrays.toString(f.searchRange(arr, 8)));
    }

    private int[] searchRange(int[] arr, int target)
    {
        int result[] = {-1, -1};

        int leftIndex = getExtremeIndex(arr, target, true);

        if(leftIndex == arr.length || arr[leftIndex] != target) return result;

        result[0] = leftIndex;
        result[1] = getExtremeIndex(arr, target, false) - 1;

        return result;
    }

    private int getExtremeIndex(int[] arr, int target, boolean left)
    {
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2 ;

            if(arr[mid] > target || left && arr[mid] == target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
