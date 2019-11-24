package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class PreorderAndInorderConstructBinaryTree {

    int preOrderIndex = 0;

    public static void main(String args[]){
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };

        PreorderAndInorderConstructBinaryTree pI = new PreorderAndInorderConstructBinaryTree();
        Tree root = pI.constructBinaryTree(preorder, inorder);
        pI.inorder(root);
        System.out.println();
        pI.preorder(root);
    }

    private Tree constructBinaryTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return constructBinaryTreeUtil(preorder, 0, preorder.length - 1, map);
    }

    // map (9->0, 3->1, 15->2, 20->3, 7->4)

    private Tree constructBinaryTreeUtil(int[] preorder, int start, int end, Map<Integer, Integer> map) {

        if(start > end){
            return null;
        }
        int data = preorder[preOrderIndex++];
        Tree root = new Tree(data);
        if(start == end){
            return root;
        }
        int index = map.get(data);
        root.left = constructBinaryTreeUtil(preorder, start, index - 1, map);
        root.right = constructBinaryTreeUtil(preorder, index + 1, end, map);
        return root;
    }

    private void inorder(Tree root) {
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private void preorder(Tree root){
        if(root != null){
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
