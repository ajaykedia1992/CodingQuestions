package Facebook.PreviousInterviews.FacebookPremium;


import Facebook.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalTreeOrder
{
    public static void main(String args[])
    {
        Tree root = new Tree(0);
        root.left = new Tree(5);
        root.right = new Tree(1);
        root.left.left = new Tree(9);
        root.right.left = new Tree(2);
        root.right.left.right = new Tree(3);
        root.right.left.right.right = new Tree(8);
        root.right.left.right.left = new Tree(4);
        root.right.left.right.left.left = new Tree(6);
        root.right.left.right.left.left.left = new Tree(7);

        VerticalTreeOrder v = new VerticalTreeOrder();
        List<List<Integer>> res = v.verticalTraversal(root);
        for (List<Integer> l : res) {
            System.out.println(l);
        }

    }

    public List<List<Integer>> verticalTraversal(Tree root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        for (TreeMap<Integer, PriorityQueue<Integer>> nested : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> p : nested.values()) {
                while (!p.isEmpty()) {
                    res.get(res.size() - 1).add(p.poll());
                }
            }
        }

        return res;
    }

    private void dfs(Tree root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map)
    {
        if (root == null) {
            return;
        }

        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }

        map.get(x).get(y).add(root.data);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }

}
