/*
https://leetcode.com/problems/merge-k-sorted-lists/
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
package Top50FacebookQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList
{
    public static void main(String args[]){
        MergeKSortedList m = new MergeKSortedList();
        ListNode l1 = m.insert(new int[] {1, 4, 5});
        ListNode l2 = m.insert(new int[]{1, 3, 4});
        ListNode l3 = m.insert(new int[]{2, 6});
        ListNode[] head = new ListNode[] {l1, l2, l3};
        ListNode res = m.mergeKLists(head);
        m.print(res);
    }

    private void print(ListNode res)
    {
        while(res.next != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print(res.val);
    }

    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        for(ListNode l : lists){
            if(l != null)
                priorityQueue.add(l);
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while(!priorityQueue.isEmpty()){
            ListNode temp = priorityQueue.poll();
            head.next = temp;
            temp = temp.next;
            head = head.next;
            if(temp != null){
                priorityQueue.add(temp);
            }
        }
        return dummy.next;
    }

    public ListNode insert(int[] nums){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        int i = 0;
        while(i < nums.length){
            head.next = new ListNode(nums[i]);
            head = head.next;
            i++;
        }
        return dummy.next;
    }

}
