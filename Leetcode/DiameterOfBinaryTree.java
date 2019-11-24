package Leetcode;

class Tree{
    int data;
    Tree left;
    Tree right;
    Tree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DiameterOfBinaryTree {

    static int ans = 0;

    public static void main(String args[]){
        Tree root = new Tree(10);
        root.left = new Tree(1);
        root.right = new Tree(4);
        root.left.left = new Tree(5);
        root.left.right = new Tree(7);
        root.left.right.left = new Tree(6);
        root.left.right.right = new Tree(1);
        root.left.right.right.left = new Tree(2);
        root.right.left = new Tree(9);
        root.right.right = new Tree(3);
        root.right.left.left = new Tree(11);

        int diameterLength = new DiameterOfBinaryTree().getDiameterOfTree(root);
        System.out.println(diameterLength);
    }

    private int getDiameterOfTree(Tree root) {
        ans = 1;
        getDiameterOfTreeUtil(root);
        return ans - 1;
    }

    private int getDiameterOfTreeUtil(Tree root) {
        if(root == null){
            return 0;
        }

        int left = getDiameterOfTreeUtil(root.left);
        int right = getDiameterOfTreeUtil(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
