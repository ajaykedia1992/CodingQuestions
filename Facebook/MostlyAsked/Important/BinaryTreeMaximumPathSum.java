/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
package Facebook.MostlyAsked.Important;

public class BinaryTreeMaximumPathSum
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(-10);
        root.left  = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        int sum = b.maxPathSum(root);
        System.out.println(sum);
    }

    public int maxPathSum(TreeNode root) {

        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSumUtil(root, max);
        return max[0];
    }

    public int maxPathSumUtil(TreeNode root, int[] max){
        if(root == null) return 0;

        int leftMax = maxPathSumUtil(root.left, max);
        int rightMax = maxPathSumUtil(root.right, max);

        int currentSum = Math.max(root.val, Math.max(leftMax, rightMax) + root.val);

        max[0] = Math.max(max[0], Math.max(leftMax + rightMax + root.val , currentSum));

        return currentSum;
    }
}
