/*
https://leetcode.com/problems/k-closest-points-to-origin/solution/
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
Note:

1) 1 <= K <= points.length <= 10000
2) -10000 < points[i][0] < 10000
3) -10000 < points[i][1] < 10000
 */

package Top50FacebookQuestions;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointToOrigin
{
    class Points{
        int[] point;
        double distance;
        Points(int[] point, double distance){
            this.point = point;
            this.distance = distance;
        }
    }
    public static void main(String args[]){
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k = 2;
        KClosestPointToOrigin closestPointToOrigin = new KClosestPointToOrigin();
        int[][] res = closestPointToOrigin.kClosest(points, k);
        for(int[] r : res){
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] kClosest(int[][] points, int k){
        if(points == null || points.length == 0) return new int[][]{};

        if(k > points.length) return new int[][]{};

        PriorityQueue<Points> priorityQueue = new PriorityQueue<Points>((o1, o2) -> {
            Double distance1 = o1.distance;
            Double distance2 = o2.distance;
            return -1 * distance1.compareTo(distance2);
        });

        for(int[] point : points){
            priorityQueue.add(new Points(point, distance(point)));
            if(priorityQueue.size() > k){
                priorityQueue.remove();
            }
        }

        int[][] res = new int[k][2];

        while(k > 0){
            res[--k] = priorityQueue.poll().point;
        }

        return res;
    }

    public double distance(int[] point){
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
