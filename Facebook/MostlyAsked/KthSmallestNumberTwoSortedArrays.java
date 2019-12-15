/*
https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
 */
package Facebook.MostlyAsked;

import java.util.Arrays;

public class KthSmallestNumberTwoSortedArrays
{
    public static void main(String args[]){
        int[] arr1 = {1, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 8, 9};
        int k = 6;

        KthSmallestNumberTwoSortedArrays m = new KthSmallestNumberTwoSortedArrays();
        System.out.println(m.getKthSmallestSortedArraysUtil1(arr1, arr1.length,  arr2, arr2.length, k));
        System.out.println(m.getKthSmallestSortedArraysUtil(arr1, arr1.length,  arr2, arr2.length, k));
    }

    private  int getKthSmallestSortedArraysUtil(int arr1[], int m, int arr2[],
                     int n, int k)
    {
        if (k > (m + n) || k < 1)
            return -1;

        // let m > n
        if (m > n)
            return getKthSmallestSortedArraysUtil(arr2, n, arr1, m, k);

        // if arr1 is empty returning k-th element of arr2
        if (m == 0)
            return arr2[k - 1];

        // if k = 1 return minimum of first
        // two elements of both arrays
        if (k == 1)
            return Math.min(arr1[0], arr2[0]);

        // now the divide and conquer part
        int i = Math.min(m, k / 2);
        int j = Math.min(n, k / 2);

        if (arr1[i - 1] > arr2[j - 1])
        {
            // Now we need to find only k-j th element
            // since we have found out the lowest j
            int temp[] = Arrays.copyOfRange(arr2, j, n);
            return getKthSmallestSortedArraysUtil(arr1, m, temp, n - j, k - j);
        }

        // Now we need to find only k-i th element
        // since we have found out the lowest i
        int temp[] = Arrays.copyOfRange(arr1, i, m);
        return getKthSmallestSortedArraysUtil(temp, m - i, arr2, n, k - i);
    }

    private  int getKthSmallestSortedArraysUtil1(int arr1[], int m, int arr2[],
                                                int n, int k)
    {
        if(m > n){
            return getKthSmallestSortedArraysUtil1(arr2, n, arr1, m, k);
        }

       if(k < 1 || k > m + n){
           return -1;
       }

       if(m == 0) return arr2[k -1];

       if(k == 1) return Math.min(arr1[k - 1], arr2[k - 1]);

       int i = Math.min(m, k / 2);
       int j = Math.min(n, k/2);

       if(arr1[i - 1] > arr2[j - 1]){
           int[] temp = Arrays.copyOfRange(arr2, j, n);
           return getKthSmallestSortedArraysUtil1(arr1, m, temp, n - j, k - j);
       }
       int [] temp = Arrays.copyOfRange(arr1, i, m);
       return getKthSmallestSortedArraysUtil1(temp, m - i, arr2, n, k - i);
    }
}
