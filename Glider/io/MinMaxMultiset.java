package Glider.io;

import java.util.Arrays;

public class MinMaxMultiset
{
    public static void main(String[] args) {
        int N = 5;
        int[] numbers = {3, 1, 2, 3, 4};
        MinMaxMultiset.getMaxAndMinSubset(N, numbers);
    }
// {1,2,3,3,4}
    public static void getMaxAndMinSubset(int N, int[] arr){
        Arrays.sort(arr);
        int maxNumberIndex = N - 1;
        while(maxNumberIndex >0 && arr[maxNumberIndex - 1] == arr[maxNumberIndex]){
            maxNumberIndex--;
        }

        int maxNumber = N - maxNumberIndex;

        int minNumberIndex = 0;
        while(minNumberIndex < N - 1 && arr[minNumberIndex] == arr[minNumberIndex + 1]){
            minNumberIndex++;
        }
        int minNumber = minNumberIndex + 1;

        int maxMultisetValue = (int)((Math.pow(2, maxNumber) - 1) % (Math.pow(10, 9) + 7));
        int minMultisetValue = (int)((Math.pow(2, minNumber) - 1) % (Math.pow(10, 9) + 7));

        System.out.print(maxMultisetValue + " " + minMultisetValue);
    }
}
