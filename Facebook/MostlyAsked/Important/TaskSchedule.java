package Facebook.MostlyAsked.Important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TaskSchedule
{
    public static void main(String args[])
    {
        int[][] task = {{1, 10}, {2, 6}, {3, 7}, {4, 8}};
        TaskSchedule t = new TaskSchedule();
        List<int[]> multitask = t.intersections(task);
        t.print(multitask);
    }

    List<int[]> intersections(int[][] ints){
        LinkedList<int[]> multiTask = new LinkedList<>();
        if(ints.length == 0)
            return multiTask;
        int[] prev = ints[0];
        for(int i = 1; i < ints.length; i++){
            int[] curr = ints[i];
            if(curr[0] < prev [1]){
                int[] intersection = new int[]{Math.max(prev[0], curr[0]), Math.min(prev[1], curr[1])};
                if(!multiTask.isEmpty() && intersection[0] < multiTask.peekLast()[1]){
                    intersection = merge(multiTask.pollLast(), intersection);
                }
                multiTask.add(intersection);
            }
            prev = new int[]{Math.max(prev[0], curr[0]), Math.max(prev[1], curr[1])};

        }
        return multiTask;
    }

    private int[] merge(int[] pollLast, int[] intersection)
    {
        return new int[] {Math.min(pollLast[0], intersection[0]), Math.max(pollLast[1], intersection[1])};
    }

    private void print(List<int[]> arr)
    {
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }

}
