package Facebook;

import Top50FacebookQuestions.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal
{
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LevelOrderTraversal l = new LevelOrderTraversal();
        List<List<Integer>> res = l.levelOrder(root);
        for(List<Integer> r : res){
            System.out.println(r);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        List<Integer> tempList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                if(tempList.isEmpty()) break;
                res.add(new ArrayList<>(tempList));
                tempList = new ArrayList<>();
                queue.add(null);
            }else{
                tempList.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return res;
    }
}
