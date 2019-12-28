/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
package Top50FacebookQuestions;

public class BinaryTreeMaximumPathSum
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {

        if(root == null) return 0;

        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPathSumUtil(root, res);
        return res[0];
    }

    public int maxPathSumUtil(TreeNode root, int[] res){
        if(root == null) return 0;

        int left = maxPathSumUtil(root.left, res);
        int right = maxPathSumUtil(root.right, res);

        int currentSum = Math.max(root.val, Math.max(left, right) + root.val);
        res[0] = Math.max(res[0], Math.max(currentSum, left + right +root.val));
        return currentSum;
    }
}
