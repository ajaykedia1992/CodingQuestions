/*
https://www.lintcode.com/problem/inorder-successor-in-bst/description
 */
package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

public class InorderSuccessor
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(p.right != null){
            return findMinimum(p.right);
        }

        TreeNode successor = null;
        while(root != null){
            if(p.val < root.val){
                successor = root;
                root = root.left;
            }else if(p.val > root.val){
                root = root.right;
            }else{
                break;
            }
        }
        return successor;
    }

    public TreeNode findMinimum(TreeNode p){
        while(p.left != null){
            p = p.left;
        }
        return p;
    }
}
