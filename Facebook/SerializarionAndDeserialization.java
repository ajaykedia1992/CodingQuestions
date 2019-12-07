package Facebook;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializarionAndDeserialization
{
    public static final String SPLITTER = ",";
    public static final String NULL = "X";

    public static void main(String args[])
    {
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(15);
        SerializarionAndDeserialization s = new SerializarionAndDeserialization();
        String data = s.serialize(root);
        System.out.println(data);
        Tree head = s.deserialize(data);
        s.preOrder(head);

    }
    public String serialize(Tree root) {

        StringBuilder s = new StringBuilder();
        serializeUtil(root, s);
        s.delete(s.length() - 1, s.length());
        return s.toString();
    }

    public void serializeUtil(Tree root, StringBuilder s){


        if(root == null){
            s.append(NULL).append(SPLITTER);
            return;
        }

        s.append(root.data).append(SPLITTER);
        serializeUtil(root.left, s);
        serializeUtil(root.right, s);
    }

    public Tree deserialize(String data) {

        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(SPLITTER)));
        Tree root = deserializeUtil(queue);

        return root;
    }

    public Tree deserializeUtil(Queue<String> queue){
        if(queue.peek().equals(NULL)){
            queue.poll();
            return null;
        }
        Tree r = new Tree(Integer.parseInt(queue.poll()));


        r.left = deserializeUtil(queue);
        r.right = deserializeUtil(queue);
        return r;
    }

    public void preOrder(Tree root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}

