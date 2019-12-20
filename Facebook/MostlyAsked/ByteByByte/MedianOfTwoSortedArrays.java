package Facebook.MostlyAsked.ByteByByte;

public class MedianOfTwoSortedArrays
{
    public static void main(String args[]){
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {2, 4, 6, 8};
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        System.out.println(m.medianOfTwoSortedArrays(arr1, arr2));
    }

    private double medianOfTwoSortedArrays(int[] arr1, int[] arr2)
    {
        if(arr1.length > arr2.length){
            return medianOfTwoSortedArrays(arr2, arr1);
        }

        int m = arr1.length;
        int n = arr2.length;

        int low = 0;
        int high = m - 1;
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (m + n + 1)/2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : arr1[partitionX];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : arr2[partitionY];

            if(maxX <= minY && maxY <= minX){
                if((m + n) % 2 == 0){
                    return (((double) Math.max(maxX, maxY)) + Math.min(minX, minY))/2;
                }else{
                    return Math.max(maxX, maxY);
                }
            }
            else if(maxX > minY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }
        return -1;
    }
}
