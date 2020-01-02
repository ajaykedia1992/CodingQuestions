/*
https://www.lintcode.com/problem/lowest-common-ancestor-iii/description
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.
Input:
{4, 3, 7, #, #, 5, 6}
3 5
5 6
6 7
5 8
Output:
4
7
7
null
Explanation:
  4
 / \
3   7
   / \
  5   6

LCA(3, 5) = 4
LCA(5, 6) = 7
LCA(6, 7) = 7
LCA(5, 8) = null

 */
package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

public class LowestCommonAncestor
{
    boolean v1 = false, v2 = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null) return root;
        TreeNode temp = helper(root, A, B);
        if(v1 & v2) return temp;
        return null;
    }

    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return root;

        TreeNode temp = null;
        if(root == A){
            temp = root;
            v1 = true;
        }
        if(root == B){
            temp = root;
            v2 = true;
        }
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);

        if(temp != null) return temp;

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}
