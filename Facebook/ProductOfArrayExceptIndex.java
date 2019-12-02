/*
https://leetcode.com/problems/product-of-array-except-self/
Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
 */
package Facebook;

import java.util.Arrays;

public class ProductOfArrayExceptIndex
{
    public static void main(String args[]){
        int[] arr = {1,2,3,4};
        ProductOfArrayExceptIndex p = new ProductOfArrayExceptIndex();
        System.out.println(Arrays.toString(p.productExceptSelf(arr)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0){
            return result;
        }

        Arrays.fill(result, 1);
        int forwardProduct = 1;
        int backwardProduct = 1;
        int forwardIndex = 0;
        int backwardIndex = nums.length - 1;
        while(forwardIndex < nums.length - 1){
            forwardProduct *= nums[forwardIndex];
            result[++forwardIndex] *= forwardProduct;

            backwardProduct *= nums[backwardIndex];
            result[--backwardIndex] *= backwardProduct;
        }
        return result;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0){
            return result;
        }
        int product = 1;
        for(int n : nums){
            product *= n;
        }

        int index = -1;
        int countZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                index = i;
                countZero++;
            }else{
                result[i] = product/nums[i];
            }
        }

        if(countZero == 1){
            int zeroProduct = 1;
            for(int i = 0; i < nums.length; i++){
                if(i == index) continue;
                zeroProduct *= nums[i];
            }
            result[index] = zeroProduct;
        }

        return result;
    }
}
