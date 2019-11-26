package ByteByByte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KthMostFrequentString
{
    public static void main(String args[]){
        String arr[] = {"a", "a", "b", "c", "b", "c", "b", "c", "d"};
        int k = 0;

        KthMostFrequentString kth = new KthMostFrequentString();
        String result = kth.getMostFrequentString(arr, k);
        System.out.println(result);
    }

    private String getMostFrequentString(String[] arr, int k)
    {
        if(arr == null || arr.length == 0){
            return null;
        }

        if(k < 0){
            throw new IllegalArgumentException();
        }

        Map<String, Integer> map = new HashMap<>();

        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0) + 1) ;
        }

        List<Entry> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry>()
        {
            @Override
            public int compare(Entry o1, Entry o2)
            {
                Integer v1 = (Integer) o1.getValue();
                Integer v2 = (Integer) o2.getValue();
                return -1 * v1.compareTo(v2);
            }
        });

        return k > list.size() ? null : (String) list.get(k).getKey();
    }
}
