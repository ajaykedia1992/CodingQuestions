package Leetcode;

public class MedianOfTwoStrings {
    public static void main(String args[]){
        int a1[] = {1,3,5,7,8,9};
        int b1[] = {2,4,6,10};
        double d = new MedianOfTwoStrings().getMedian(a1, b1);
        System.out.println(d);
    }

    public double getMedian(int[] A, int B[]){
        if(A.length > B.length){
            return getMedian(B , A);
        }
        int small = A.length;
        int big = B.length;
        int l = 0;
        int h = small;
        while(l <= h){

            int partitionX = (l + h)/2;
            int partitionY = (small + big + 1)/2 - partitionX;

            int minX = (partitionX == 0) ? Integer.MIN_VALUE : A[partitionX - 1];
            int maxX = (partitionX == small) ? Integer.MAX_VALUE : A[partitionX];
            int minY = (partitionY == 0) ? Integer.MIN_VALUE : B[partitionY - 1];
            int maxY = (partitionY == big) ? Integer.MAX_VALUE : B[partitionY];

            if(minX <= maxY && minY <= maxX){
                if((small + big) % 2 == 0){
                    return (double)(Math.max(minX, minY) + Math.min(maxX, maxY))/2;
                }else{
                    return (Math.max(minX, minY));
                }
            }
                if(minX > maxY){
                    h = partitionX -1;
                }else{
                    l = partitionX + 1;
                }

        }
        return 0.0;
    }
}
