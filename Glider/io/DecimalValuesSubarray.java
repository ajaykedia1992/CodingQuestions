/*
For a given binary array with size of N, find the number represented by the subarray of a queried range.
Input
5
2
1 0 1 1 0
0 2
2 4
Output
5
6
 */
package Glider.io;

import java.util.Arrays;

public class DecimalValuesSubarray
{
    public static void main(String args[]){
        int N = 5;
        int arr[] = {0, 0, 0, 0, 1};
        int L = 0;
        int R = 3;
        int decimal = DecimalValuesSubarray.solution1(N, arr, L, R);
        System.out.println(decimal);
    }

    private static int solution(int N, int[] arr, int L, int R)
    {
        int[] pre = new int[N];
        preCompute(N, arr, pre);
        System.out.println(Arrays.toString(pre));
        return getDecimalValuesSubArray(N, arr, pre, L, R);
    }

    private static int getDecimalValuesSubArray(int n, int[] arr, int[] pre, int L, int R)
    {
        if(R != n - 1){
            return (pre[L] - pre[R + 1]) / (1 << (n - 1 - R));
        }else{
            return pre[L] / (1 << (n - 1 - R));
        }
    }

    private static void preCompute(int n, int[] arr, int[] pre)
    {
        Arrays.fill(pre, 0);
        pre[n - 1] = arr[n - 1] * (int)Math.pow(2, 0);
        for(int i = n - 2; i >= 0; i--){
            pre[i] = pre[i + 1] + arr[i] * (1 << (n - i - 1));
        }
    }

    private static int solution1(int N, int[] arr, int L, int R){
        int sum =0;
        while(L<=R){
            sum = (sum<<1) + arr[L++];
        }
        return sum;
    }
}
