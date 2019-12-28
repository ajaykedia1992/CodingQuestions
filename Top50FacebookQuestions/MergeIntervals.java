/*
https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

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
        int[][] res = new MergeIntervals().merge(intervals);
        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] i : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < i[0]){
                merged.add(i);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            }
        }

        int[][] result = new int[merged.size()][2];
        int k = 0;
        for(int[] r : merged){
            result[k++] = r;
        }
        return result;

    }
}
