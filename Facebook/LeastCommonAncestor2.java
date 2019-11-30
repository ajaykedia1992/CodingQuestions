package Facebook;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor2
{
    public static void main(String args[])
    {
        Tree root = new Tree(10);
        root.left = new Tree(7);
        root.right = new Tree(15);
        root.left.left = new Tree(4);
        root.left.right = new Tree(9);
        root.right.left = new Tree(12);
        root.right.right = new Tree(19);
        Tree result = findLeastCommonAncestor(root, 12, 19);
        System.out.println(result.data);
    }

    private static Tree findLeastCommonAncestor(Tree root, int value1, int value2)
    {
        if (root == null) {
            return null;
        }
        List<Tree> path1 = new ArrayList<>();
        List<Tree> path2 = new ArrayList<>();

        findLeastCommonAncestor(root, value1, path1);
        findLeastCommonAncestor(root, value2, path2);

        if (path1.size() == 0 || path2.size() == 0) {
            return null;
        }
        else {
            Tree result = findLCS(path1, path2);
            return result;
        }
    }

    private static boolean findLeastCommonAncestor(Tree root, int value, List<Tree> path)
    {
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == value){
            return true;
        }
        if(root.left != null && findLeastCommonAncestor(root.left, value, path)){
            return true;
        }
        if(root.right != null && findLeastCommonAncestor(root.right, value, path)){
            return true;
        }
        path.remove(path.size() - 1);

        return false;
    }

    private static Tree findLCS(List<Tree> path1, List<Tree> path2)
    {
        int i = 0;

        while (path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i - 1);
    }
}
