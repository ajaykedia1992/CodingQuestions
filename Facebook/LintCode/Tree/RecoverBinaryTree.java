/*
https://leetcode.com/problems/recover-binary-search-tree/
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
 */
package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

public class RecoverBinaryTree
{
    TreeNode first = null, middle = null, last = null, prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorderHelper(root);

        if(first != null && last != null){
            swap(first, last);
        }else if(first != null && middle != null){
            swap(first, middle);
        }
    }

    public void inorderHelper(TreeNode root){
        if(root != null){
            inorderHelper(root.left);

            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev;
                    middle = root;
                }else{
                    last = root;
                }
            }
            prev = root; // 4
            inorderHelper(root.right);
        }
    }

    public void swap(TreeNode first, TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
