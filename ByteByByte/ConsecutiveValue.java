package ByteByByte;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsecutiveValue
{
    public static void main(String args[]){
        int[] arr = {1, 3, 5, 1};
        ConsecutiveValue c = new ConsecutiveValue();
        int count = c.getConsecutiveValue(arr);
        System.out.println(count);
    }

    private int getConsecutiveValue(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int count = 0;
        Set<Integer> values = new HashSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for(int i : values){
            if(values.contains(i - 1)) continue;
            int max = 0;
            while(values.contains(i++)){
                max++;
            }
            if(max > count){
                count = max;
            }
        }
        return count;
    }
}
