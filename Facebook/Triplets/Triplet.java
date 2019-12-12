package Facebook.Triplets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet
{
    public static void main(String []args){
        int[] arr = {1, 2, 3, -1, - 2, -1, 0};
        Triplet H = new Triplet();
        List<int[]> result = H.getTriplet(arr, 0);
        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }
    }

    public List<int[]> getTriplet(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(arr);
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i++){
            if(i != 0 && arr[i] == arr[i-1]) continue;
            int j = i;
            int k = arr.length - 1;
            while(j <= k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    int[] r = {arr[i], arr[j], arr[k]};
                    result.add(r);
                    k--;
                    while(k < arr.length && arr[k] == arr[k + 1]){
                        k--;
                        continue;
                    }
                }

                else if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return result;
    }
}
