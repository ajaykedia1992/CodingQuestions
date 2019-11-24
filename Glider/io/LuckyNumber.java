package Glider.io;

import java.util.HashSet;
import java.util.Set;

public class LuckyNumber
{
    public static void main(String args[]){
        int arr[] = {7, 13, 14, 49, 56, 343, 63, 350, 70, 399};
        int n = 10;
        int output = LuckyNumber.solve(arr, n);
        System.out.println(output);
    }
    static int solve(int[] arr, int n){

        int output = 0;
        for(int  i : arr){
            Set<Integer> track = new HashSet<>();
            boolean status = solveUtil((long) i, track);
            if(status) output++;

        }
        return output;
    }

    static boolean solveUtil(long value, Set<Integer> track){
        long number = 7;
        while(value >= number){
            number *= 7;
        }
        number /= 7;
        long leftOver = value - number;
        int val = (int) number;
        if(leftOver >= 7){
            if(track.contains(val)) return false;
                track.add(val);
            return solveUtil(leftOver, track);
        }
        if(leftOver == 0.0){
            if(track.contains(val)) return false;
            return true;
        }
        else{
            return false;
        }
    }
}
