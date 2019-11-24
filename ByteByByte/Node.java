package ByteByByte;

public class Node
{
    int data;
    Node next;

    public Node(){

    }

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    public Node(int[] arr)
    {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                insert(arr[i]);
            }
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void insert(int data)
    {
        Node temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void display()
    {
        Node temp = this;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
