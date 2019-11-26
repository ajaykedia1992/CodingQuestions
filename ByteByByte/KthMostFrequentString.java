package ByteByByte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class KthMostFrequentString
{
    public static void main(String args[])
    {
        String arr[] = {"a", "a", "b", "c", "b", "c", "b", "c", "d"};
        int k = 0;

        KthMostFrequentString kth = new KthMostFrequentString();
        String result = kth.getKthMostFrequentString(arr, k);
        System.out.println(result);
    }

    public static String getKthMostFrequentString(String[] str, int k)
    {

        if (str == null || str.length == 0) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> map = new HashMap<>();

        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                Integer v1 = o1.getValue();
                Integer v2 = o2.getValue();
                return -1 * v1.compareTo(v2);
            }
        });

        return k > list.size() ? null : list.get(k).getKey();

    }
}
