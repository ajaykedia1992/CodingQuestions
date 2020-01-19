package Facebook.GenerateRandom;

import Facebook.Tree;

public class TreeToDoublyLinkedList
{
    public static void main(String args[])
    {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(7);
        root.left.right = new Tree(5);
        root.right.left = new Tree(9);
        root.right.right = new Tree(4);
        TreeToDoublyLinkedList t = new TreeToDoublyLinkedList();
        t.inorder(root);
        System.out.println();
        root = t.treeToLinkedList(root);
        Tree temp = root.left;
        temp.right = null;
        root.left = null;
        t.printDoublyLinkedList(root);
    }

    private Tree treeToLinkedList(Tree root)
    {
        if(root == null) return null;

        Tree left = treeToLinkedList(root.left);
        Tree right = treeToLinkedList(root.right);

        root.left = root;
        root.right = root;

        root = concatenate(left, root);
        root = concatenate(root, right);
        return root;
    }

    private Tree concatenate(Tree a, Tree b)
    {
        if(a== null) return b;
        if(b == null)  return a;

        Tree aEnd = a.left;
        Tree bEnd = b.left;

        aEnd.right = b;
        b.left = aEnd;
        a.left = bEnd;
        bEnd.right = a;
        return a;
    }

    private void printDoublyLinkedList(Tree root)
    {
        while(root != null){
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    private void inorder(Tree root)
    {
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

}
