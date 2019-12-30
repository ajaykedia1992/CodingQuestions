/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.
        7
     /    \
   3      15
         /  \
        9   20

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 */
package Top50FacebookQuestions;

import java.util.Stack;

public class BinarySearchTreeIterator
{
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root)
    {
        stack = new Stack<>();
        getLeftNode(root);
    }

    /**
     * @return the next smallest number
     */
    public int next()
    {
        TreeNode left = stack.pop();
        if (left.right != null) {
            getLeftNode(left.right);
        }
        return left.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext()
    {
        if (!stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public void getLeftNode(TreeNode root)
    {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

}
