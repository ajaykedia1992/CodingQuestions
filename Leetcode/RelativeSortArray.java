package Leetcode;

import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {

    public static void main(String args[]){
        int arr1[] ={2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
        int[] result = new RelativeSortArray().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0){
            return arr1;
        }

        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        Arrays.sort(arr1);

        int[] result = new int[arr1.length];

        for(int i = 0; i < arr1.length; i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i], i);
            }
        }
        int j = 0;
        for(int i : arr2){
            if(map.containsKey(i)){
                int index = map.get(i);
                while(index < arr1.length && i == arr1[index]){
                    result[j++] = i;
                    index++;
                }
                map.remove(i);
            }
        }
        for(Integer k : map.keySet()){
            int index = map.get(k);
            while(index < arr1.length && k == arr1[index]){
                result[j++] = k;
                index++;
            }
        }

        return result;
    }
}
