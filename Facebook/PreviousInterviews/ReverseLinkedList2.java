package Facebook.PreviousInterviews;

public class ReverseLinkedList2
{
    public static void main(String args[])
    {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(5);

        ReverseLinkedList2 r = new ReverseLinkedList2();
        LinkedList head = r.reverseBetween(list, 2, 4);
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

    public LinkedList reverseBetween(LinkedList head, int m, int n) {
        if(head == null) return null;
        LinkedList dummy = new LinkedList(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        LinkedList pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        LinkedList start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        LinkedList then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }
}
