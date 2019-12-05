package Facebook.Important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LineIntersection{
    public static void main(String args[]){

        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};

        int[][] res = new LineIntersection().getLineIntersections(A, B);

        for(int [] r : res){
            System.out.println(Arrays.toString(r));
        }
    }

    private int[][] getLineIntersections(int[][] A, int[][] B){
        List<int[]> res = new ArrayList<>();
        if(A.length == 0 || B.length == 0){
            return new int[][]{};
        }

        int i = 0, j = 0;
        while(i < A.length && j < B.length){

            int[] interval = new int[2];

            interval[0] = Math.max(A[i][0], B[j][0]);
            interval[1] = Math.min(A[i][1], B[j][1]);

            if(valid(interval)) res.add(interval);

            if(A[i][1] < B[j][1]){
                i++;
            }else{
                j++;
            }
        }

        int[][] result = new int[res.size()][2];

        for(i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;

    }

    private boolean valid(int[] interval){
        return interval[0] <= interval[interval.length - 1];
    }
}
