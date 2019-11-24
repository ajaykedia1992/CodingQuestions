
/*
    Find the median of two sorted arrays.
 */
package ByteByByte;

public class MedianOfTwoSortedArray
{
    public static void main(String args[])
    {
        int arr1[] = {1, 3, 5};
        int arr2[] = {2, 4, 6};
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();
        double median = medianOfTwoSortedArray.getMedian(arr1, arr2);
        System.out.println(median);
    }

    private double getMedian(int[] arr1, int[] arr2)
    {
        if(arr1.length > arr2.length){
            return getMedian(arr2, arr1);
        }

        int x = arr1.length;
        int y  = arr2.length;
        int low = 0;
        int high = x;

        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MIN_VALUE : arr2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y) %2 == 0){
                    return (((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                }else{
                    return Math.max(maxLeftX, maxLeftY);
                }
            }

            if(maxLeftX > minRightY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
