/*
https://leetcode.com/problems/reorder-list/discuss/44992/Java-solution-with-3-steps
 */
package Facebook.PreviousInterviews;

import sun.awt.image.ImageWatched.Link;

import java.util.Stack;

public class ReorderLinkedList
{
    public static void main(String args[]){
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(5);
        list.next.next.next.next.next = new LinkedList(6);
        ReorderLinkedList r = new ReorderLinkedList();
        LinkedList head = r.reorderLinkedList(list);
        r.print(head);
    }

    private void print(LinkedList head)
    {
        LinkedList temp = head;
        while(temp.next != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    private LinkedList reorderLinkedList(LinkedList head)
    {
        // find middle node

        LinkedList slow = head;
        LinkedList fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedList middle = slow;
        LinkedList nextCurr = middle.next;
        // 1  ->  2  ->  3  ->  4  ->  5  ->  6
        //             mid  nextcurr   curr
        while(nextCurr.next != null){
            LinkedList curr = nextCurr.next;
            nextCurr.next = curr.next;
            curr.next = middle.next;
            middle.next = curr;
        }

        // 1  ->  2  ->  3  ->  6  ->  5  ->  4
        // p1           mid     p2     curr

        LinkedList p1 = head;
        LinkedList p2 = middle.next;
        while(p1 != middle){
            middle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = middle.next;
        }

        return head;
    }

}
