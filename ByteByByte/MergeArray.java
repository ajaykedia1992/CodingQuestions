/*
Given 2 sorted arrays, A and B, where A is long enough to hold the
contents of A and B, write a function to copy the contents of B into A without
using any buffer or additional memory.
A = {1,3,5,0,0,0}
B = {2,4,6}
mergeArrays(A, B)
A = {1,2,3,4,5,6}
 */
package ByteByByte;

import java.util.Arrays;

public class MergeArray
{
    public static void main(String args[]){
        int A[] = {1, 3, 5, 0, 0, 0, 0, 0};
        int B[] = {0, 1, 2, 4, 6};
        MergeArray m = new MergeArray();
        A = m.mergeArrays(A, B);
        System.out.println(Arrays.toString(A));
    }

    private int[] mergeArrays(int[] A, int[] B)
    {
        if((A == null || A.length == 0) && (B == null || B.length == 0)){
            throw new IllegalArgumentException();
        }
        if(A == null || A.length == 0){
            return B;
        }
        if(B == null || B.length == 0){
            return A;
        }

        if(A.length < B.length){
            return mergeArrays(B, A);
        }

        int sizeB  = B.length;
        int sizeA = A.length - B.length;
        sizeA--;
        sizeB--;
        int n = A.length - 1;
        while(sizeA >= 0  && sizeB >= 0){
            if(A[sizeA] >= B[sizeB]){
                A[n] = A[sizeA--];
            }else {
                A[n] = B[sizeB--];
            }
            n--;
        }
        while(sizeA >= 0){
            A[n--] = A[sizeA--];
        }
        while(sizeB >= 0){
            A[n--] = B[sizeB--];
        }

        return A;
    }
}
