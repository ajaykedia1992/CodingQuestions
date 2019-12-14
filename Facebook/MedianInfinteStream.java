package Facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianInfinteStream
{
    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        MedianInfinteStream m = new MedianInfinteStream();
        m.getMedian(arr);
    }

    private void getMedian(int[] arr)
    {
        double median[] = new double[arr.length];
        PriorityQueue<Integer> higher = new PriorityQueue<>(); // top will contains the lower one - > ascending order
        PriorityQueue<Integer> lower = new PriorityQueue<>((a,b) -> -1 * (a - b)); // top will contains the higher one -> descending order
        for(int i = 0; i < arr.length; i++){
            insertData(arr[i], lower, higher);
            rebalanceData(lower, higher);
            median[i] = getMedianHelper(lower, higher);
        }

        print(median);
    }

    private void print(double[] median)
    {
        System.out.print(Arrays.toString(median));
    }

    private double getMedianHelper(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
    {
        PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;

        if(smaller.size() == bigger.size()){
            return ((double) smaller.peek() + bigger.peek()) / 2;
        }else{
            return bigger.peek();
        }
    }

    private void rebalanceData(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
    {
        PriorityQueue<Integer> bigger = lower.size() > higher.size() ? lower : higher;
        PriorityQueue<Integer> smaller = lower.size() > higher.size() ? higher : lower;

        if(bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }

    private void insertData(int data, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher)
    {
        if(lower.size() == 0 || data < lower.peek()){
            lower.add(data);
        }else{
            higher.add(data);
        }
    }
}
