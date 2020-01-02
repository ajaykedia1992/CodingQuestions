package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelBinaryTree
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        AverageOfLevelBinaryTree a = new AverageOfLevelBinaryTree();
        System.out.println(a.averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        helper(root, res, queue);
        return res;
    }

    public void helper(TreeNode root, List<Double> res, Queue<TreeNode> queue){
        queue.add(root);
        queue.add(null);
        long ans = 0;
        boolean isValue = false;
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                if(isValue == false) break;
                double avg = (double)ans / count;
                count = 0;
                isValue = false;
                ans = 0;
                res.add(avg);
                queue.add(null);
            }else{
                ans += temp.val;
                count++;
                if(temp.left != null){
                    isValue = true;
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    isValue = true;
                    queue.add(temp.right);
                }
            }
        }
        if(count != 0){
            res.add((double)ans / count);
        }
    }
}
