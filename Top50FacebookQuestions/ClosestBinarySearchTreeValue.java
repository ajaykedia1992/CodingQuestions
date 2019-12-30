/*
https://leetcode.com/problems/closest-binary-search-tree-value/
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 */
package Top50FacebookQuestions;

public class ClosestBinarySearchTreeValue
{
    public int closestValue(TreeNode root, double target) {
        int val, closest = root.val;

        while(root != null){
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;

            root = val < target ? root.right : root.left;
        }
        return closest;
    }
}
