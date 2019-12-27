/*
https://leetcode.com/problems/product-of-array-except-self/
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
package Top50FacebookQuestions;

import java.util.Arrays;

public class ProductOfArrayExceptSelf
{
    public static void main(String args[]){
        int[] arr = {1, 2, 3, 4};
        int[] res = new ProductOfArrayExceptSelf().productExceptSelf(arr);
        System.out.println(Arrays.toString(res));
    }

    private int[] productExceptSelf(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return new int[] {};
        }

        int product = 1;
        for(int i : arr){
            product *= i;
        }

        int[] res = new int[arr.length];
        int countZero = 0;
        int zeroIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                countZero++;
                zeroIndex = i;
                continue;
            }
            res[i] = product / arr[i];
        }

        if(countZero == 1){
            product = 1;
            for(int i = 0; i < arr.length; i++){
                if(i == zeroIndex){
                    continue;
                }
                product *= arr[i];
            }
            res[zeroIndex] = product;
        }
        return res;
    }
}
