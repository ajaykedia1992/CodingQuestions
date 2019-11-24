package ByteByByte;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationOfIntegers
{
    public static void main(String args[]){
        int arr[] = {1, 2, 3};
        PermutationOfIntegers permutationOfIntegers = new PermutationOfIntegers();
        ArrayList<int[]> resultArrayList = permutationOfIntegers.getPermutation(arr);
        for(int[] val : resultArrayList){
            System.out.println(Arrays.toString(val));
        }
    }

    private ArrayList<int[]> getPermutation(int[] arr)
    {
        ArrayList<int[]> arrayList = new ArrayList<>();
        getPermutationUtil(arr, 0, arrayList);
        return arrayList;
    }

    private void getPermutationUtil(int[] arr, int start, ArrayList<int[]> arrayList)
    {
        if(start >= arr.length){
            arrayList.add(arr.clone());
        }else{
            for(int i = start; i < arr.length; i++){
                swapValues(arr, start, i);
                getPermutationUtil(arr, start + 1, arrayList);
                swapValues(arr, start, i);
            }
        }
    }

    private void swapValues(int[] arr, int start, int i)
    {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }
}
