/*
https://leetcode.com/problems/sum-of-left-leaves/
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

public class SumOfLeftLeaves
{
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null){
            if(root.left.left ==null && root.left.right == null){
                ans += root.left.val;
            }else{
                ans += sumOfLeftLeaves(root.left);
            }
        }
        if(root.right != null){
            ans += sumOfLeftLeaves(root.right);
        }
        return ans;
    }
}
