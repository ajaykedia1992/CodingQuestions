package ByteByByte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedArray
{
    public static void main(String args[])
    {
        List<List<Integer>> arrayList = new ArrayList<List<Integer>>()
        {{
            add(Arrays.asList(1, 2, 3));
            add(Arrays.asList(2, 5, 8));
            add(Arrays.asList(3, 6, 9));
        }};

        MergeSortedArray m = new MergeSortedArray();
        List<Integer> result = m.mergeSortedArrays(arrayList);
        System.out.println(result);

    }

    private List<Integer> mergeSortedArrays(List<List<Integer>> list)
    {
        List<Integer> result = new ArrayList<>();
        if(list == null ||  list.size() == 0){
            return result;
        }

        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>()
        {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2)
            {
                Integer a = o1.get(0);
                Integer b = o2.get(0);
                return a.compareTo(b);
            }
        });

        for(List l : list){
            priorityQueue.add(l);
        }

        while (!priorityQueue.isEmpty()){
            List<Integer> l = priorityQueue.poll();
            Integer val = l.get(0);
            l = l.subList(1, list.size());
            result.add(val);
            if(!l.isEmpty()){
                priorityQueue.add(l);
            }
        }
        return result;
    }
}
