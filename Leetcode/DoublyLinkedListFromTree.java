package Leetcode;

public class DoublyLinkedListFromTree {

    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(5);
        root.right = new Tree(4);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.right.left = new Tree(9);
        root.right.right = new Tree(10);

        new DoublyLinkedListFromTree().printTree(root);
        root = new DoublyLinkedListFromTree().treeDoublyLinkedList(root);
        Tree rootEnd = root.left;
        rootEnd.right = null;
        root.left = null;
        System.out.println();
        new DoublyLinkedListFromTree().printDoublyLinkedList(root);
    }

    private void printTree(Tree root) {
        //Inorder
        Tree temp = root;
        printInorderTree(temp);
    }

    private void printInorderTree(Tree temp) {
        if(temp != null){
            printInorderTree(temp.left);
            System.out.print(temp.data +"->");
            printInorderTree(temp.right);
        }
    }

    private void printDoublyLinkedList(Tree root) {
        Tree temp = root;
        while(temp.right != null){
            System.out.print(temp.data + "->");
            temp = temp.right;
        }
        System.out.print(temp.data);
    }

    private Tree treeDoublyLinkedList(Tree root) {
        if(root == null){
            return root;
        }
        Tree left = treeDoublyLinkedList(root.left);
        Tree right = treeDoublyLinkedList(root.right);

        root.left = root;
        root.right = root;

        root = concatnate(left, root);
        root = concatnate(root, right);

        return root;
    }

    private Tree concatnate(Tree a, Tree b) {

        if(a == null) return b;
        if(b == null) return a;

        Tree aEnd = a.left;
        Tree bEnd = b.left;

        a.left = bEnd;
        bEnd.right = a;
        aEnd.right = b;
        b.left = aEnd;

        return a;
    }
}
