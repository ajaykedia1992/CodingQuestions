/*
Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */
package Facebook;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfTree
{
    public static void main(String args[]){
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.right = new Tree(5);
        root.right.right = new Tree(4);
        RightViewOfTree r = new RightViewOfTree();
        System.out.println(r.rightSideView(root));
    }


    private List<Integer> rightSideView(Tree root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        rightSideViewHelper(root, 0 , res);
        return res;
    }

    private void rightSideViewHelper(Tree root, int level, List<Integer> res)
    {
        if(root == null) return;
        if(level == res.size()){
            res.add(root.data);
        }
        rightSideViewHelper(root.right, level + 1, res);
        rightSideViewHelper(root.left, level + 1, res);
    }
}
