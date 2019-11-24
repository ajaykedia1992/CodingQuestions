package Leetcode;

import java.util.*;

class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString(){
        return "(" + i + ", " + j + ")";
    }
}

class Distance{
    double d;
    Pair p;
    Distance(Pair p, double d){
        this.p = p;
        this.d = d;
    }
}

public class ClosestPoint {
    public static void main(String args[]){
        ClosestPoint c = new ClosestPoint();
        List<Pair> listOfPairs = new ArrayList<>();
        listOfPairs.addAll(Arrays.asList(new Pair(4,2), new Pair(3,-1), new Pair(2 ,1 ), new Pair(2,3)));
        Pair vertex = new Pair(2,2);
        List<Pair> result = c.getClosestPoint(listOfPairs, vertex, 2);
        for(Pair p : result){
            System.out.println(p);
        }
    }

    private List<Pair> getClosestPoint(List<Pair> listOfPairs, Pair vertex, int k) {
        PriorityQueue<Distance> priorityQueue = new PriorityQueue<>(new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                Double d1 = o1.d;
                Double d2 = o2.d;
                return -1 * d1.compareTo(d2);
            }
        });

        for(Pair p : listOfPairs){
            double distance = calculateDistance(p, vertex);
            if(priorityQueue.size() < k){
                priorityQueue.add(new Distance(p, distance));
            }else{
                if(distance < priorityQueue.peek().d){
                    priorityQueue.poll();
                    priorityQueue.add(new Distance(p, distance));
                }
            }
        }
        List<Pair> result = new ArrayList<>();
        for(Distance d : priorityQueue){
            result.add(d.p);
        }
        return result;
    }

    private double calculateDistance(Pair p1, Pair p2){
        int x1 = p2.i - p1.i;
        int y1 = p2.j - p1.j;

        return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
    }
}
