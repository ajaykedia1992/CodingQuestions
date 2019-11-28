/*
Array can have duplicate, negative and positive
You can use a number more than once
Only Integers are allowed
Output: Distinct ones
 */
package Coderpad.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSum
{
    public static void main(String args[]){
        int arr[] = {5, -5, 0, 1, -1, 1, 0, 2};
        int sum = 0;

        TripletSum tripletSum = new TripletSum();
        List<int[]> result = tripletSum.getAllTriplet(arr, sum);
        for(int[] value : result){
            System.out.println(Arrays.toString(value));
        }
    }

    private List<int[]> getAllTriplet(int[] arr, int sum)
    {
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Set<String> track = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(i != 0){
                if(arr[i] == arr[i - 1]){
                    continue;
                }
            }
            int j = i;
            int k = arr.length - 1;
            while(j <= k){
                int s = arr[i] + arr[j] + arr[k];
                String str = arr[i] + ":" + arr[j] + ":" + arr[k];
                if(s == sum){
                    if(!track.contains(str)){
                        track.add(str);
                        result.add(new int[] {arr[i], arr[j], arr[k]});
                    }
                    j++;
                }
                else if(s < sum){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}
