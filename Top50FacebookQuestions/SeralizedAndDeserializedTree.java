/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SeralizedAndDeserializedTree
{
    private final static String SPLITTER = ",";
    private final static String NULL = "X";

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SeralizedAndDeserializedTree s = new SeralizedAndDeserializedTree();
        s.print(root);
        System.out.println();
        String serialize = s.serialize(root);
        System.out.println(serialize);
        TreeNode head = s.deserialize(serialize);
        s.print(head);
    }

    private void print(TreeNode head)
    {
        if(head != null){
            print(head.left);
            System.out.print(head.val + " ");
            print(head.right);
        }
    }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        serializeUtil(root, str);
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder str)
    {
        if(root == null){
            str.append(NULL).append(SPLITTER);
            return;
        }
        str.append(root.val).append(SPLITTER);
        serializeUtil(root.left, str);
        serializeUtil(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITTER)));
        TreeNode root = deserializeUtil(queue);
        return root;
    }

    private TreeNode deserializeUtil(Queue<String> queue)
    {
        if(queue.peek().equals(NULL)){
            queue.poll();
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
        root.left = deserializeUtil(queue);
        root.right = deserializeUtil(queue);
        return root;
    }
}
