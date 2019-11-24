package Leetcode;

import java.util.Arrays;

public class ClosestSumToZero {

    public static void main(String args[]){
        int[] arr = { 1, 60, -10, 70, -80, 85 };
        int sum = 0;
        int n = arr.length;
        ClosestSumToZero c = new ClosestSumToZero();
        int closestSum = c.getClosestSumToZero(arr, sum);
        System.out.println(closestSum);
    }

    private int getClosestSumToZero(int[] arr, int sum) {

        if(arr == null || arr.length == 0){
            return 0;
        }

        if(arr.length < 2){
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        int diff = Integer.MAX_VALUE;
        int minL = -1, minR = -1;
        while(l < r){
            int s = Math.abs(arr[l] + arr[r]);
            if(s < diff){
                diff = s;
                minL = arr[l];
                minR = arr[r];
            }

            if(s > diff){
                r--;
            }
            else{
                l++;
            }
        }

        System.out.println("(" + minL + " ," + minR + ")");
        return minL + minR;
    }
}
