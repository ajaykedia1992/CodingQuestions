/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AllNodeKDistanceInBinaryTree
{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) return new ArrayList<>();

        if(K < 0) return new ArrayList<>();

        Map<TreeNode, TreeNode> parents = new HashMap<>();

        findAllParents(root, null, parents);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        Queue<TreeNode> seen = new LinkedList<>();
        seen.add(target);
        seen.add(null);

        return findAllDistanceK(root, target, K, queue, seen, 0, parents);

    }

    public List<Integer> findAllDistanceK(TreeNode root, TreeNode target, int K, Queue<TreeNode> queue, Queue<TreeNode> seen, int level, Map<TreeNode, TreeNode> parents){
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            if(temp == null){
                if(level == K){
                    List<Integer> res = new ArrayList<>();
                    while(!queue.isEmpty()){
                        res.add(queue.poll().val);
                    }
                    return res;
                }
                level++;
                queue.add(null);
            }else{
                if(!seen.contains(temp.left)){
                    queue.add(temp.left);
                    seen.add(temp.left);
                }
                if(!seen.contains(temp.right)){
                    queue.add(temp.right);
                    seen.add(temp.right);
                }
                TreeNode p = parents.get(temp);
                if(!seen.contains(p)){
                    queue.add(p);
                    seen.add(p);
                }
            }
        }
        return new ArrayList<>();
    }

    public void findAllParents(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents){
        if(root != null){
            parents.put(root, parent);
            findAllParents(root.left, root, parents);
            findAllParents(root.right, root, parents);
        }
    }
}
