/*
https://www.geeksforgeeks.org/combinations-every-element-appears-twice-distance-appearances-equal-value/
Given a positive number n, we need to find all the combinations of 2*n elements such that every element from 1 to n
appears exactly twice and distance between its appearances is exactly equal to value of the element.
Examples:

Input :  n = 3
Output : 3 1 2 1 3 2
         2 3 1 2 1 3
All elements from 1 to 3 appear
twice and distance between two
appearances is equal to value
of the element.

Input :  n = 4
Output : 4 1 3 1 2 4 3 2
         2 3 4 2 1 3 1 4
 */

package Facebook.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationNumber
{
    public static void main(String args[]){
        int n = 4;
        CombinationNumber c = new CombinationNumber();
        List<List<Integer>> res = c.getAllCombinations(n);
        for(List<Integer> r : res){
            System.out.println(r);
        }
    }

    private List<List<Integer>> getAllCombinations(int n)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0) return res;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 2 * n; i++) arr.add(-1);
        getAllCombinations(res, arr, n, 1);
        return res;
    }

    private void getAllCombinations(List<List<Integer>> res, List<Integer> arr, int n, int element)
    {
        if(element > n){
            res.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < 2 * n; i++){
            if(arr.get(i) == -1 && (i + element + 1) < 2 * n && arr.get(i + element + 1) == -1){
                arr.set(i, element);
                arr.set(i + element + 1,  element);
                getAllCombinations(res, arr, n, element + 1);
                arr.set(i , -1);
                arr.set(i + element + 1, -1);
            }
        }
    }
}
