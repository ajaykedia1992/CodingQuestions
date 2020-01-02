package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        BinaryTreePath b = new BinaryTreePath();
        System.out.println(b.binaryTreePaths(root));
    }

    private List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, "", res);
        return res;
    }

    private void helper(TreeNode root, String path, List<String> res)
    {
        if(root.left == null && root.right == null) res.add(path + root.val);
        if(root.left != null) helper(root.left, path + root.val + "->",  res);
        if(root.right != null) helper(root.right, path + root.val + "->",  res);
    }
}
