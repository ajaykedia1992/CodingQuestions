/*
https://leetcode.com/problems/meeting-intervals-ii/

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference intervals required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2
{
    public static void main(String args[])
    {
        int[][] intervals = {
                {0, 30},
                {5, 10},
                {15, 20},
                {16, 17},
                {16, 21}
        };
        MeetingRoom2 m = new MeetingRoom2();
        int number = m.minMeetingRooms(intervals);
        System.out.println(number);
    }

    private int minMeetingRooms(int[][] intervals)
    {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        for (int i[] : intervals) {
            if (!queue.isEmpty() && queue.peek()[1] <= i[0]) {
                queue.poll();
            }
            queue.add(i);
        }
        return queue.size();
    }

    private int minMeetingRooms1(int[][] intervals)
    {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] arr = new int[1000000];
        for (int r[] : intervals) {
            arr[r[0]]++;
            arr[r[1]]--;
        }

        int minRoom = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (minRoom < sum) {
                minRoom = sum;
            }
        }
        return minRoom;
    }
}
