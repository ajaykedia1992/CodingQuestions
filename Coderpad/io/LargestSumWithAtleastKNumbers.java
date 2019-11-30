/*
Input : arr[] = {-4, -2, 1, -3}
            k = 2
Output : -1
The sub array is {-2, 1}

Input : arr[] = {1, 1, 1, 1, 1, 1}
            k = 2
Output : 6
The sub array is {1, 1, 1, 1, 1, 1}
 */
package Coderpad.io;

public class LargestSumWithAtleastKNumbers
{
    public static void main(String args[]) {
        int arr[] = {-4, -2, 1, -3};
        int k = 2;

        System.out.println(findTheLargestSumWithAtleastK(arr, k));
    }

    private static int findTheLargestSumWithAtleastK(int[] arr, int k)
    {
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(k >= arr.length){
            throw new IllegalArgumentException();
        }

        int[] maxSum = new int[arr.length];
        maxSum[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            maxSum[i] = Math.max(arr[i], maxSum[i - 1] + arr[i]);
        }

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        int result = sum;

        for(int i = k; i < arr.length; i++){
            sum = sum + arr[i] - arr[i - k];
            result = Math.max(result, sum);
            result = Math.max(result, sum + maxSum[i - k]);
        }

        return result;
    }

}
