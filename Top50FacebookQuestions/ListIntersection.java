/*
https://leetcode.com/problems/interval-list-intersections/
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real
numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
Example 1:
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
Note:
0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntersection
{
    public static void main(String args[]){
        ListIntersection l = new ListIntersection();
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = l.intervalIntersection(A, B);
        for(int i[] : res){
            System.out.println(Arrays.toString(i));
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0) return new int[][]{};
        List<int[]> temp = new ArrayList<>();

        int i = 0, j = 0;
        while(i < A.length && j  < B.length){
            int first = Math.max(A[i][0], B[j][0]);
            int second = Math.min(A[i][1], B[j][1]);

            int[] interval = {first, second};
            if(validity(interval)){
                temp.add(interval);
            }
            if(A[i][1] < B[j][1]){
                i++;
            }else{
                j++;
            }
        }

        int[][] res = new int[temp.size()][2];
        int k = 0;
        for(int t[] : temp){
            res[k++] = t;
        }
        return res;
    }

    private boolean validity(int[] interval)
    {
        return interval[0] <= interval[1];
    }
}
