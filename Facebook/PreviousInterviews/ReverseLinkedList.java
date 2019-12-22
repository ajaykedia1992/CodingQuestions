package Facebook.PreviousInterviews;

import java.util.Stack;

/*
Use less than linear space. We will create the smaller chunks of size sqrt(number of nodes)
 */
public class ReverseLinkedList
{
    public static void main(String args[])
    {
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(5);
        list.next.next.next.next.next = new LinkedList(6);

        ReverseLinkedList r = new ReverseLinkedList();
        r.reverseLinkedList(list);
    }

    private void reverseLinkedList(LinkedList head)
    {
        // total number of nodes

        int numberOfNodes = totalNumberOfNodes(head);

        int steps = (int)Math.sqrt(numberOfNodes) + 1;
        Stack<LinkedList> stack = new Stack<>();

        createSmallerChunks(head, stack, steps);

        printReverseOrder(stack);
    }

    private void printReverseOrder(Stack<LinkedList> stack)
    {
        LinkedList startNode = null;
        LinkedList endNode;
        LinkedList temp;

        while(!stack.isEmpty()){
            endNode = startNode;
            startNode = stack.pop();
            temp = startNode;
            Stack<LinkedList> s = new Stack<>();
            while (temp != endNode){
                s.push(temp);
                temp = temp.next;
            }

            while(!s.isEmpty()){
                System.out.print(s.pop().val + " ");
            }
        }
    }

    private void createSmallerChunks(LinkedList head, Stack<LinkedList> stack, int steps)
    {
        LinkedList temp = head;
        int i = 0;
        while(temp != null){
            if(i % steps == 0){
                stack.push(temp);
            }
            temp = temp.next;
            i++;
        }
    }

    private int totalNumberOfNodes(LinkedList head)
    {
        LinkedList temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
