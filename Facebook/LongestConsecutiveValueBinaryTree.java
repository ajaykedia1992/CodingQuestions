package Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class LongestConsecutiveValueBinaryTree
{
    public static void main(String args[])
    {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(3);
        root.right.left = new Tree(4);
        root.right.right = new Tree(6);
        root.right.left.left = new Tree(5);
        root.right.left.left.left = new Tree(6);
        root.right.left.left.left.left = new Tree(9);
        LongestConsecutiveValueBinaryTree l = new LongestConsecutiveValueBinaryTree();
        int count = l.getLongestConsecutiveSequenceBinaryTree(root);
        System.out.println(count);
        System.out.println(l.longestConsecutive(root));
    }

    //DFS
    private int getLongestConsecutiveSequenceBinaryTree(Tree root)
    {
        if (root == null) {
            return 0;
        }
        return Math.max(getLongestConsecutiveSequenceBinaryTree(root.left, root.data, 1), getLongestConsecutiveSequenceBinaryTree(root.right, root.data, 1));
    }

    private int getLongestConsecutiveSequenceBinaryTree(Tree root, int prev, int length)
    {
        if (root == null) {
            return 0;
        }
        else {
            if (root.data == prev + 1) {
                int leftMax = getLongestConsecutiveSequenceBinaryTree(root.left, root.data, length + 1);
                int rightMax = getLongestConsecutiveSequenceBinaryTree(root.right, root.data, length + 1);
                return max(leftMax, rightMax);
            }
            else {
                int leftMax = getLongestConsecutiveSequenceBinaryTree(root.left, root.data, length);
                int rightMax = getLongestConsecutiveSequenceBinaryTree(root.right, root.data, length);
                return max(leftMax, rightMax, length);
            }
        }
    }

    private int max(int... dataues)
    {
        int temp = Integer.MIN_VALUE;
        for (int v : dataues) {
            if (temp < v) {
                temp = v;
            }
        }
        return temp;
    }

    //BFS

    public int longestConsecutive(Tree root)
    {
        if (root == null) {
            return 0;
        }

        Queue<Tree> listNode = new LinkedList<>();
        Queue<Integer> sizeQueue = new LinkedList<>();

        listNode.add(root);
        sizeQueue.add(1);
        int max = 1;
        while (!listNode.isEmpty()) {
            Tree node = listNode.poll();
            int size = sizeQueue.poll();
            if (node.left != null) {
                int leftSize = size;
                if (node.data == node.left.data - 1) {
                    leftSize++;
                    max = Math.max(max, leftSize);
                }
                else {
                    leftSize = 1;
                }
                listNode.add(node.left);
                sizeQueue.add(leftSize);
            }
            if (node.right != null) {
                int rightSize = size;
                if (node.data == node.right.data - 1) {
                    rightSize++;
                    max = Math.max(max, rightSize);
                }
                else {
                    rightSize = 1;
                }
                listNode.add(node.right);
                sizeQueue.add(rightSize);
            }
        }
        return max;
    }
}
