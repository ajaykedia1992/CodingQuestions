package Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfNumberStreams {
    public static void main(String args[]){
        int number[] = {1,2,3,4,5,6,7,8,9,10};
        double[] medians = new MedianOfNumberStreams().getMedian(number);
        Arrays.stream(medians).forEach(x -> System.out.print(x + " "));
    }

    private double[] getMedian(int[] number) {
        if(number == null || number.length == 0){
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        double[]medians = new double[number.length];

        for(int i = 0; i<number.length; i++){
            addNumber(number[i], minHeap, maxHeap);
            rebalance(minHeap, maxHeap);
            medians[i] = getMedian(minHeap, maxHeap);
        }
        return medians;
    }

    private void addNumber(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if(minHeap.size() == 0 || number < minHeap.peek()){
            minHeap.add(number);
        }else{
            maxHeap.add(number);
        }

    }

    private void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        PriorityQueue<Integer> bigger = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> smaller = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

        if(bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }

    private double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        PriorityQueue<Integer> bigger = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
        PriorityQueue<Integer> smaller = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;

        if(bigger.size() == smaller.size() ){
            return ((double)bigger.peek() + smaller.peek())/2;
        }else{
            return bigger.peek();
        }
    }

}
