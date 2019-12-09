package Facebook;

public class TreeToDoublyLinkedList
{
    public static void main(String args[]){
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(7);
        root.left.right = new Tree(5);
        root.right.left = new Tree(9);
        root.right.right = new Tree(4);
        TreeToDoublyLinkedList t = new TreeToDoublyLinkedList();
        t.inorder(root);
        System.out.println();
        root = t.treeToLinkedList(root);
        t.printDoublyLinkedList(root);
    }

    private Tree treeToLinkedList(Tree root)
    {
        root = treeToLinkedListUtil(root);
        Tree left = root.left;
        left.right = null;
        root.left = null;
        return root;
    }

    private void printDoublyLinkedList(Tree root)
    {
        while(root != null){
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    private Tree treeToLinkedListUtil(Tree node)
    {
        if(node == null) return node;
        Tree leftNode = treeToLinkedListUtil(node.left);
        Tree rightNode = treeToLinkedListUtil(node.right);

        node.left = node;
        node.right = node;

        node = concatenate(leftNode, node);
        node = concatenate(node, rightNode);
        return node;
    }

    private Tree concatenate(Tree a, Tree b)
    {
        if(a == null) return b;
        if(b == null) return a;

        Tree aEnd = a.left;
        Tree bEnd = b.left;

        aEnd.right = b;
        b.left = aEnd;
        a.left = bEnd;
        bEnd.right = a;
        return a;
    }

    public void inorder(Tree root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
