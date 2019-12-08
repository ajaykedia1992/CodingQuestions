package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms
{

    public static void main(String args[]){
        int [][] intervals = {
                {26,29},
                {19,28},
                {4,19},
                {4,25},
                {19,26}
        };
        System.out.println(new MinimumMeetingRooms().minMeetingRooms(intervals));
        System.out.println(new MinimumMeetingRooms().minMeetingRooms1(intervals));
    }

    public int minMeetingRooms(int[][] intervals) {
        int n = 2 * intervals.length;
        List<Integer> arrival = new ArrayList<Integer>();
        List<Integer> departure = new ArrayList<Integer>();
        for(int[] i : intervals){
            arrival.add(i[0]);
            departure.add(i[1]);
        }

        int[] activity = new int[n];

        sortActivity(arrival, departure, activity);
        System.out.println(arrival);
        System.out.println(departure);
        System.out.println(Arrays.toString(activity));
        return calculateMinMeetingRooms(activity, arrival, departure);
    }

    public int calculateMinMeetingRooms(int[] activity, List<Integer> arrival, List<Integer> departure){
        int minRoom = -1;
        int value = 0;
        for(int i = 0; i < activity.length; i++){
            int v = activity[i];
            if(arrival.size() > 0 && arrival.contains(v)){
                arrival.remove(arrival.indexOf(v));
                value += 1;
            }
            if(departure.size() > 0 && departure.contains(v)){
                departure.remove(departure.indexOf(v));
                value -= 1;
            }
            if(value > minRoom){
                minRoom = value;
            }
        }

        return minRoom;
    }

    public void sortActivity(List<Integer> arrival, List<Integer> departure, int[] activity){
        Collections.sort(arrival);
        Collections.sort(departure);
        int left = 0, right = 0;
        int k = 0;
        while(left < arrival.size() && right < departure.size()){
            if(arrival.get(left) < departure.get(right)){
                activity[k++] = arrival.get(left++);
            }else{
                activity[k++] = departure.get(right++);
            }
        }

        while(left < arrival.size()){
            activity[k] = arrival.get(left);
            left++;
            k++;
        }

        while(right < departure.size()){
            activity[k] = departure.get(right);
            right++;
            k++;
        }
    }

    public int minMeetingRooms1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> q =new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        for(int[] i : intervals){
            System.out.println(Arrays.toString(i));
        }
        for(int[] i : intervals){
            if(!q.isEmpty() && q.peek()[1] <= i[0]){
                q.poll();
            }
            q.add(i);
        }

        return q.size();
    }
}
