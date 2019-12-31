/*
https://leetcode.com/problems/monotonic-array/
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.
 */
package Top50FacebookQuestions;

public class MonotonicArray
{
    public boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1]){
                isIncreasing = true;
            }
            else if(A[i] < A[i - 1]){
                isDecreasing = true;
            }
        }
        if(isIncreasing && isDecreasing) return false;
        return true;
    }
}
