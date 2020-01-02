package Facebook;

public class InorderSuccessor
{
    Tree root;
    InorderSuccessor(){
        root = null;
    }

    public void insert(int data){
        root = insertUtil(root, data);
    }

    private Tree insertUtil(Tree root, int data)
    {
        if(root == null){
            root = new Tree(data);
            return root;
        }

        if(root.data < data){
            root.right = insertUtil(root.right, data);
        }else{
            root.left = insertUtil(root.left, data);
        }
        return root;
    }

    private int inorderSuccessor(Tree data)
    {
        Tree node = inorderSuccessorUtil(root, data);
        return node.data;
    }

    private Tree inorderSuccessorUtil(Tree root, Tree data)
    {
        if(data.right != null){
            return findMinimum(data.right);
        }
        Tree successor = null;

        while(root != null) {
            if (data.data < root.data) {
                successor = root;
                root = root.left;

            }
            else if(data.data > root.data){
                root = root.right;
            }else{
                break;
            }
        }
        return successor;
    }

    private Tree findMinimum(Tree node)
    {
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void main(String args[]){
        InorderSuccessor tree = new InorderSuccessor();
        tree.insert(5);
        tree.insert(3);
        tree.insert(10);
        tree.insert(2);
        tree.insert(20);
        tree.insert(4);
        int data = tree.inorderSuccessor(tree.root.right);
        System.out.println(data);
    }
}

//                  5
//                /  \
//              3     10
//            /  \      \
//           2    4     20