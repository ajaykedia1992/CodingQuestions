package Coderpad.io;

public class LeastCommonAncestor1
{
    static boolean v1 = false, v2 = false;
    public static void main(String args[])
    {
        Tree root = new Tree(10);
        root.left = new Tree(7);
        root.right = new Tree(15);
        root.left.left = new Tree(4);
        root.left.right = new Tree(9);
        root.right.left = new Tree(12);
        root.right.right = new Tree(19);
        Tree result = findLeastCommonAncestor(root, 4, 19);
        if(result == null){
            System.out.println("No least common ancestor");
        }else{
            System.out.println(result.data);
        }
    }

    private static Tree findLeastCommonAncestor(Tree root, int value1, int value2)
    {
        if(root == null){
            return null;
        }

        Tree lcs = findLeastCommonAncestorUtil(root, value1, value2);
        if(v1 && v2){
            return lcs;
        }else{
            return null;
        }
    }

    private static Tree findLeastCommonAncestorUtil(Tree root, int value1, int value2)
    {
        if(root == null){
            return null;
        }

        Tree temp = null;

        if(root.data == value1){
            temp = root;
            v1 = true;
        }

        if(root.data == value2){
            temp = root;
            v2 = true;
        }

        Tree leftLCS = findLeastCommonAncestorUtil(root.left, value1, value2);
        Tree rightLCS = findLeastCommonAncestorUtil(root.right, value1, value2);

        if(temp != null){
            return temp;
        }

        if(leftLCS != null && rightLCS != null){
            return root;
        }

        return leftLCS != null ? leftLCS : rightLCS;
    }
}
