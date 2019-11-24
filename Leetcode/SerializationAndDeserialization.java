package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializationAndDeserialization {

    private static final String SPLITTER = ",";
    private static final String NULLCHECK = "X";

    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(15);

        SerializationAndDeserialization sd = new SerializationAndDeserialization();
        sd.preOrder(root);
        System.out.println();
        String sb = sd.serilization(root);
        System.out.println(sb);

        root = sd.deserialization(sb);
        sd.preOrder(root);

    }

    private Tree deserialization(String sb) {

        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(sb.split(SPLITTER)));

        Tree root = deserializationUtil(queue);
        return root;
    }

    private Tree deserializationUtil(Queue<String> queue) {

        if(queue.peek().equals(NULLCHECK)){
            queue.poll();
            return null;
        }
        int data = Integer.parseInt(queue.poll());
        Tree root = new Tree(data);
        root.left = deserializationUtil(queue);
        root.right = deserializationUtil(queue);

        return root;
    }

    private String serilization(Tree root) {

        StringBuilder sb = new StringBuilder("");
        serilizationUtil(root, sb);
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }

    private void serilizationUtil(Tree root, StringBuilder sb) {
        if(root == null){
            sb.append(NULLCHECK).append(SPLITTER);
            return;
        }

        sb.append(root.data).append(SPLITTER);
        serilizationUtil(root.left, sb);
        serilizationUtil(root.right, sb);
    }

    public void preOrder(Tree root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
