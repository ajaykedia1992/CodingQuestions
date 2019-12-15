package Facebook.MostlyAsked;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms
{
    public static void main(String args[]){
        int [][] intervals = {
            {26,29},
            {19,28},
            {4,19},
            {4,25},
            {19,26}
        };
        MeetingRooms m = new MeetingRooms();
        int room = m.getMinimumMeetingRooms(intervals);
        System.out.print(room);
    }

    private int getMinimumMeetingRooms(int[][] intervals)
    {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x-> x[1]));

        for(int[] i : intervals){
            if(!priorityQueue.isEmpty() && i[0]>= priorityQueue.peek()[1]){
                priorityQueue.poll();
            }
            priorityQueue.add(i);
        }

        return priorityQueue.size();
    }
}
