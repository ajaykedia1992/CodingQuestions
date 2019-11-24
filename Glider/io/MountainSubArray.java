package Glider.io;

import java.util.Arrays;

public class MountainSubArray
{
    public static void main(String[] args){
        int n = 8;
        int[] arr = {5, 6, 5, 4, 3, 2, 8, 9};
        int L = 0, R = 4;
        boolean isMountain = MountainSubArray.solution(arr, L, R);
        System.out.println(isMountain ? "YES" : "NO");
    }

    static void preprocess(int arr[], int N, int left[], int right[])
    {
        left[0] = 0;
        int lastIncr = 0;

        for (int i = 1; i < N; i++)
        {
            if (arr[i] > arr[i - 1])
                lastIncr = i;
            left[i] = lastIncr;
        }
        right[N - 1] = N - 1;
        int firstDecr = N - 1;

        for (int i = N - 2; i >= 0; i--)
        {
            if (arr[i] > arr[i + 1])
                firstDecr = i;
            right[i] = firstDecr;
        }
    }
    static boolean isSubarrayMountainForm(int arr[], int left[],
                                          int right[], int L, int R)
    {
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return (right[L] >= left[R]);
    }

    static boolean solution(int arr[],  int L, int R){
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        preprocess(arr, arr.length, left, right);
        return isSubarrayMountainForm(arr, left, right, L, R);
    }
}
