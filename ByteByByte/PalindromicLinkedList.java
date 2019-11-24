package ByteByByte;


import java.util.Stack;

public class PalindromicLinkedList
{
    public static void main(String args[]){
        Node linkedList = new Node(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(1);
        linkedList.display();

        PalindromicLinkedList palindromicLinkedList = new PalindromicLinkedList();
        boolean isPalindrom = palindromicLinkedList.isPalindrom(linkedList);
        System.out.print(isPalindrom);
    }

    private boolean isPalindrom(Node head)
    {
        if(head == null){
            return true;
        }
        Node slow = head;
        Node faster = head;
        Stack<Integer> stack = new Stack<>();
        while(faster != null  && faster.next != null){
            stack.push(slow.data);
            slow = slow.next;
            faster = faster.next.next;
        }

        if(faster != null){
            slow = slow.next;
        }

        while(slow != null){
            if(stack.pop() != slow.data) return false;
            slow = slow.next;
        }
        return true;
    }
}
