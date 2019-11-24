/*
        1<=X<=(len(Array))
 */
package ByteByByte;

import java.util.HashSet;
import java.util.Set;

public class DuplicateValue
{
    public static void main(String args[])
    {
        int arr[] = {1,1};
        DuplicateValue d = new DuplicateValue();
        Set<Integer> result = d.findDuplicates(arr);
        System.out.print(result);
    }

    private Set<Integer> findDuplicates(int[] arr)
    {
        Set<Integer> result = new HashSet<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            if(arr[val - 1] < 0){
                result.add(Math.abs(val));
            }else{
                arr[val - 1] *= -1;
            }

        }
        return result;
    }
    // 0    1   2  3   4  5
    // -1, -2, -3, 2, -6, 3
}
