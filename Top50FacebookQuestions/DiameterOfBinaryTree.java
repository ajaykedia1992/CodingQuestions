/*
https://leetcode.com/problems/diameter-of-binary-tree/
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
package Top50FacebookQuestions;

public class DiameterOfBinaryTree
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        res[0] = 0;
        helper(root, res);
        return res[0] - 1;
    }

    public int helper(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);

        res[0] = Math.max(res[0], left + right + 1);

        return Math.max(left, right) + 1;
    }
}
