/*
https://www.lintcode.com/problem/leaf-similar-trees/description
https://leetcode.com/problems/leaf-similar-trees/submissions/
 */
package Facebook.LintCode.Tree;

import Top50FacebookQuestions.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
                5
              /  \
            1     4
                 / \
                3   6
 */
public class LeafSimilarTrees
{

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> value1 = new ArrayList<>();
        List<Integer> value2 = new ArrayList<>();
        dfs(root1, value1);
        dfs(root2, value2);
        return value1.equals(value2);
    }

    public void dfs(TreeNode root, List<Integer> value){
        if(root == null) return;
        if(root.left == null && root.right == null){
            value.add(root.val);
        }

        dfs(root.left, value);
        dfs(root.right, value);
    }
}
