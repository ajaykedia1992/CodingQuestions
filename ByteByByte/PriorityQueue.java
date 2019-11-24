package ByteByByte;

public class PriorityQueue
{
    int[] heap;
    int size;

    PriorityQueue(int maxSize){
        heap = new int[maxSize];
        size = 0;
    }

    public void insert(int data){
        if(size >= heap.length){
            throw new IllegalStateException();
        }
        heap[size++] = data;
        balance(size - 1);

    }

    public void balance(int index){
        int parent = (index - 1)/2;
        if(heap[parent] >= heap[index]){
            return ;
        }
        swapValues(parent, index);
        balance(parent);
    }

    public void swapValues(int parent, int index)
    {
        int temp = heap[parent];
        heap[parent] = heap[index];
        heap[index] = temp;
    }

    public void display(){
        for(int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
    }

    public int remove(){
        if(size == 0){
            throw new IllegalStateException();
        }
        int top = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;
        size--;
        for(int i = 0; i < size/2; i++){
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if(leftChild < size && heap[leftChild] >= heap[rightChild]){
                if(heap[leftChild] > heap[i]){
                    swapValues(leftChild, i);
                }
            }else if(rightChild < size && heap[rightChild] >= heap[leftChild]){
                if(heap[rightChild] > heap[i]){
                    swapValues(rightChild, i);
                }
            }else {
                break;
            }
        }
        return top;
    }

    public static void main(String args[]){
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(5);
        priorityQueue.insert(10);
        priorityQueue.insert(7);
        priorityQueue.display();
        int top = priorityQueue.remove();
        System.out.println();
        System.out.println(top);
        priorityQueue.display();
    }

    //      10
    //     / \
   //     8   9
   //    / \ / \
   //   4  5 6  7

}
