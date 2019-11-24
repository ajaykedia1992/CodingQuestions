package Glider.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderOfTheSequence
{
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String args[]){
        int number = 4;

        int value = LeaderOfTheSequence.getSolution(number);
        int value1 = LeaderOfTheSequence.solution(number);
        System.out.println(value);
        System.out.println(value1);
    }

    private static int solution(int number)
    {
        long nano_startTime = System.nanoTime();
        int[] arr = new int[number + 1];
        for(int i = 0; i <= number; i++){
            arr[i] = i;
        }
        List<int[]> sequences = getAllSequences(arr);
        int maxValue = Integer.MIN_VALUE;
        int[] maxValueSequence = new int[number];
        for(int[] s : sequences){
            int result = 0;
            for(int i = 0; i < s.length; i++){
                result += i ^ s[i];
            }
            if(maxValue < result){
                maxValueSequence = s;
                maxValue = result;
            }
        }

        System.out.println(Arrays.toString(maxValueSequence));
        long nano_endTime = System.nanoTime();
        System.out.println(nano_endTime - nano_startTime);
        return maxValue;
    }

    private static List<int[]> getAllSequences(int[] arr)
    {
        int start = 0;
        List<int[]> sequences = new ArrayList<>();
        getAllSequences(arr, start, sequences);
        return sequences;
    }

    private static void getAllSequences(int[] arr, int start, List<int[]> sequences)
    {
        if(start == arr.length){
            sequences.add(arr.clone());
        }else{
            for(int i = start; i < arr.length; i++){
                swap(arr, start, i);
                getAllSequences(arr, start + 1, sequences);
                swap(arr, start, i);
            }
        }
    }

    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void display(List<int[]> sequences){
        for(int[] s : sequences){
            System.out.println(Arrays.toString(s));
        }
    }

    private static int getSolution(int number){
        long nano_startTime = System.nanoTime();
        int[] arr = new int[number + 1];
        for(int i = 0; i <= number; i++){
            arr[i] = i;
        }
        getSolution(arr, 0, 0);
        long nano_endTime = System.nanoTime();
        System.out.println(nano_endTime - nano_startTime);
        return maxValue;
    }

    private static void getSolution(int arr[], int start, int value){
        if(start == arr.length){
            if(maxValue < value){
                maxValue = value;
            }
        }else{
            for(int i = start; i < arr.length; i++){
                swap(arr, start, i);
                value += arr[start] ^ start;
                getSolution(arr, start  + 1, value);
                value -= arr[start] ^ start;
                swap(arr, start, i);
            }
        }
    }
}
