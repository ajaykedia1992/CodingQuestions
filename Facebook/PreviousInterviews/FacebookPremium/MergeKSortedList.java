package Facebook.PreviousInterviews.FacebookPremium;

import Facebook.PreviousInterviews.LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList
{
    public LinkedList mergeKLists(List<LinkedList> lists){
        if(lists == null) return null;
        PriorityQueue<LinkedList> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(LinkedList l : lists){
            if(l != null)
                queue.add(l);
        }

        LinkedList res = new LinkedList(0);
        LinkedList dummy = res;
        while(!queue.isEmpty()){
            LinkedList temp = queue.remove();
            LinkedList next = temp.next;
            temp.next = null;
            res.next = temp;
            res = temp;
            if(next == null) continue;
            queue.add(next);
        }

        return dummy.next;
    }
}
