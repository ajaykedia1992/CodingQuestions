package Facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoint
{
    class Points{
        int[] points;
        double distance;
        Points(int[] points, double distance){
            this.points = points;
            this.distance = distance;
        }
    }
    public static void main(String args[])
    {
        int[][] points = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        KClosestPoint k = new KClosestPoint();
        int[][] closest = k.kClosest(points, 2);
        for(int[] c : closest) {
            System.out.println(Arrays.toString(c));
        }
    }

    private int[][] kClosest(int[][] points, int k)
    {
        if(points == null || points.length == 0){
            return new int[][]{};
        }

        PriorityQueue<Points> priorityQueue = new PriorityQueue<Points>((o1, o2) -> {
            Double distance1 = o1.distance;
            Double distance2 = o2.distance;
            return -1*distance1.compareTo(distance2);
        });

        for(int[] p : points){
            priorityQueue.add(new Points(p, calculateEuclideanDistance(p)));
            if(priorityQueue.size() > k){
                priorityQueue.remove();
            }
        }

        int[][] result = new int[k][k];
        while(k > 0 && !priorityQueue.isEmpty()){
            result[--k] = priorityQueue.remove().points;
        }

        return result;
    }

    public Double calculateEuclideanDistance(int[] coordinates){
        int x = coordinates[0];
        int y = coordinates[1];
        Double result = (double)Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        return result;
    }
}
