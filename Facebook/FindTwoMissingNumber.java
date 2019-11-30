package Facebook;

import java.util.Arrays;

public class FindTwoMissingNumber
{
    public static void main(String args[]){
        int[] arr = {1, 3, 4, 6};
        FindTwoMissingNumber f =  new FindTwoMissingNumber();
        System.out.println(Arrays.toString(f.findMissingNumber(arr)));
    }

    private int[] findMissingNumber(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return new int[] {1, 2};
        }
        int len = arr.length + 2;
        int sum = len * (len + 1) / 2;
        int arrSum = 0;
        for(int i = 0; i < arr.length; i++){
            arrSum += arr[i];
        }
        int res = sum - arrSum;
        int pivot = res / 2;
        int leftSumArray = 0;
        int rightSumArray = 0;
        int leftSumTotal = 0;
        int rightSumTotal = 0;

        for(int i = 1; i <= pivot; i++){
            leftSumTotal ^= i;
        }
        for(int i = pivot + 1; i <= len; i++){
            rightSumTotal ^= i;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= pivot){
                leftSumArray ^= arr[i];
            }else{
                rightSumArray ^= arr[i];
            }
        }
        return new int[] {leftSumTotal ^ leftSumArray , rightSumTotal ^ rightSumArray};
    }
}
