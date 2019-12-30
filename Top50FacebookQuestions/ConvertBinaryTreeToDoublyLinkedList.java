/*
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list.
For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor,
and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
input:
        4
      /  \
     2    5
   /  \
  1    3

output: 1,2,3,4,5

 */
package Top50FacebookQuestions;

public class ConvertBinaryTreeToDoublyLinkedList
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        ConvertBinaryTreeToDoublyLinkedList c = new ConvertBinaryTreeToDoublyLinkedList();
        c.printTree(root);
        System.out.println();
        root = c.treeToDoublyList(root);
        TreeNode temp = root.left;
        temp.right = null;
        root.left = null;
        c.printDoublyLinkedList(root);
    }

    private void printDoublyLinkedList(TreeNode root)
    {
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    private void printTree(TreeNode root)
    {
        if(root != null){
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public TreeNode treeToDoublyList(TreeNode root){

        if(root == null) return root;

        TreeNode left = treeToDoublyList(root.left);
        TreeNode right = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;

        root = concatenate(left, root);
        root = concatenate(root, right);
        return root;
    }

    private TreeNode concatenate(TreeNode a, TreeNode b)
    {
        if(a == null) return b;
        if(b == null) return a;

        TreeNode aEnd = a.left;
        TreeNode bEnd = b.left;

        aEnd.right = b;
        b.left = aEnd;
        bEnd.right = a;
        a.left = bEnd;
        return a;
    }
}
