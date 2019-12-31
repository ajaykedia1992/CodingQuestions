/*
Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
Input: [1,2,3,4,5,6,7]
            1
          /   \
        2      3
      /  \   /   \
    4    5  6    7
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
Note:
The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversal
{
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        fillMap(root, 0, 0, map);

        for(TreeMap<Integer, PriorityQueue<Integer>> m : map.values()){
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> p : m.values()){
                while(!p.isEmpty()){
                    res.get(res.size() - 1).add(p.poll());
                }
            }
        }
        return res;
    }

    public void fillMap(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map){
        if(root == null) return ;

        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new PriorityQueue<>());
        }

        map.get(x).get(y).add(root.val);

        fillMap(root.left, x - 1, y + 1, map);
        fillMap(root.right, x + 1, y + 1, map);
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(3);
        root.right.left.right.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(4);
        root.right.left.right.left.left = new TreeNode(6);
        root.right.left.right.left.left.left = new TreeNode(7);

        VerticalOrderTraversal v = new VerticalOrderTraversal();
        List<List<Integer>> res = v.verticalTraversal(root);
        for (List<Integer> l : res) {
            System.out.println(l);
        }

    }
}
