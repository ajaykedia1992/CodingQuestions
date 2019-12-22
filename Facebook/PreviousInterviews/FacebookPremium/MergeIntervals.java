package Facebook.PreviousInterviews.FacebookPremium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals
{
    public static void main(String args[]){
        int[][] intervals = {
                {2, 3},
                {2, 2},
                {3, 3},
                {1, 3},
                {5, 7},
                {2, 2},
                {4, 6}
        };

        MergeIntervals m = new MergeIntervals();
        List<int[]> res = m.merge(intervals);
        for(int [] i : res){
            System.out.println(Arrays.toString(i));
        }
    }

    public List<int[]> merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new LinkedList<>();

        Arrays.sort(intervals, Comparator.comparingInt(x-> x[0]));
        LinkedList<int[]> res = new LinkedList<>();

        for(int[] i : intervals){
            if(res.isEmpty() || res.getLast()[1] < i[0]){
                res.add(i);
            }else{
                res.getLast()[1] = Math.max(res.getLast()[1], i[1]);
            }
        }

        return res;
    }

}
