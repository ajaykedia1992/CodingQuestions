package Facebook.PreviousInterviews.FacebookPremium;

import Facebook.Tree;
import Leetcode.DoublyLinkedListFromTree;

public class BinaryTreeToDoublyLinkedList
{
    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(4);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right.left = new Tree(9);
        root.right.right = new Tree(10);

        BinaryTreeToDoublyLinkedList b = new BinaryTreeToDoublyLinkedList();
        b.printTree(root);
        System.out.println();
        root = b.treeDoublyLinkedList(root);
        Tree temp = root.left;
        root.left = null;
        temp.right = null;
        b.printDoublyLinkedList(root);
    }

    private void printDoublyLinkedList(Tree root)
    {
        while(root != null){
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    private Tree treeDoublyLinkedList(Tree root)
    {
        if(root == null) return null;
        Tree left = treeDoublyLinkedList(root.left);
        Tree right = treeDoublyLinkedList(root.right);

        root.left = root;
        root.right = root;

        root = concatenate(left, root);
        root = concatenate(root, right);
        return root;

    }

    private Tree concatenate(Tree a, Tree b)
    {
        if(a == null) return b;
        if(b == null) return a;

        Tree aEnd = a.left;
        Tree bEnd = b.left;
        aEnd.right = b;
        b.left = aEnd;
        bEnd.right = a;
        a.left = bEnd;
        return a;
    }

    private void printTree(Tree root) {
        //Inorder
        if(root != null){
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }
}
