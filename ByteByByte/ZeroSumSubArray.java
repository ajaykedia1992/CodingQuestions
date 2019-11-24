/*
Given an array, write a function to find any subarray that sums to zero,
if one exists.
zeroSum({1, 2, ‑5, 1, 2, ‑1}) = [2, ‑5, 1, 2]
 */
package ByteByByte;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray
{
    public static void main(String args[]){
        int[] arr = {1, -5, 1, -4, 7};
        ZeroSumSubArray z = new ZeroSumSubArray();
        int[] result = z.getZeroSumSubArray1(arr);
        System.out.println(Arrays.toString(result));
    }

    private int[] getZeroSumSubArray(int[] arr)
    {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }
        int[][] matrix = new int[arr.length][arr.length];
        int row = -1;
        int col = -1;
        boolean flag = false;
        for(int i = 0; i < arr.length; i++){
            matrix[i][i] = arr[i];
            if(matrix[i][i] == 0){
                return new int[]{matrix[i][i]};
            }
        }

        int step = 1;
        while(step < arr.length){
            int j = step;
            int i = 0;
            while(j < arr.length){
                matrix[i][j] = matrix[i][j - 1] + matrix[i + 1][j] - matrix[i+1][j-1];
                if(matrix[i][j] == 0){
                    row = i;
                    col = j;
                    flag = true;
                    break;
                }
                i++;
                j++;
                if(i + 1 >= arr.length){
                    break;
                }
            }
            if(flag) break;
            step++;
        }

        if(flag){
            return Arrays.copyOfRange(arr, row, col + 1);
        }

        return new int[]{};
    }

    private int[] getZeroSumSubArray1(int[] arr){
        if(arr == null || arr.length == 0){
            return new int[] {};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i <= arr.length; i++){
            Integer oldIndex = map.get(sum);
            if(oldIndex == null && i == arr.length){
                return null;
            }
            else if(oldIndex == null){
                map.put(sum, i);
                sum += arr[i];
            }else{
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }
        return null;
    }

    private void display(int[][] matrix){
        for(int[] m : matrix){
            System.out.println(Arrays.toString(m));
        }
    }
}
