package Facebook.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    class DLinkedList{
       int key;
       int value;
       DLinkedList post;
       DLinkedList pre;
       @Override
        public String toString(){
           return "value = " + value;
       }

    }

    DLinkedList head, tail;
    int count;
    int capacity;
    Map<Integer, DLinkedList> map = null;
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.count = 0;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        this.head.post = tail;
        this.tail.pre = head;
    }

    public void addNode(int key , int value){
        if(map.containsKey(key)){
            DLinkedList node = map.get(key);
            node.value = value;
            removeNode(node);
            addNodeToFront(node);
        }else{
            DLinkedList node = new DLinkedList();
            node.key = key;
            node.value = value;
            addNodeToFront(node);
            map.put(key, node);
            count++;
            if(count>capacity){
                int k = popTailNode(tail.pre);
                map.remove(k);
                count--;
            }
        }
    }

    public int popTailNode(DLinkedList node){
        removeNode(node);
        return node.key;
    }

    public int getNode(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        DLinkedList node = map.get(key);
        int v = removeNode(node);
        addNodeToFront(node);
        return v;
    }

    private void addNodeToFront(DLinkedList node)
    {
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
        node.pre = head;
    }

    public int removeNode(DLinkedList node){
        DLinkedList a = node.pre;
        DLinkedList b = node.post;
        a.post = b;
        b.pre = a;
        return node.value;
    }

    public static void main(String args[]){
        LRUCache l = new LRUCache(2);
        System.out.println(l.getNode(2));
        l.addNode(2, 5);
        System.out.println(l.getNode(2));
        l.addNode(1, 7);
        l.addNode(3, 7);
        System.out.println(l.getNode(2));
        System.out.println(l.getNode(3));
        l.addNode(2, 7);
        System.out.println(l.getNode(3));
        System.out.println(l.getNode(2));
        l.addNode(5, 9);
        System.out.println(l.getNode(3));
        System.out.println(l.getNode(2));
        System.out.println(l.getNode(5));
    }
}

