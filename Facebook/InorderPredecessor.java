package Facebook;

public class InorderPredecessor
{
    Tree root;
    InorderPredecessor(){
        root = null;
    }

    private void insert(int data)
    {
        root = insertUtil(root, data);
    }

    private Tree insertUtil(Tree root, int data)
    {
        if(root == null){
            root = new Tree(data);
            return root;
        }

        if(data < root.data){
            root.left = insertUtil(root.left, data);
        }
        else{
            root.right = insertUtil(root.right, data);
        }

        return root;
    }

    private int inorderPredecessor(Tree key)
    {
        Tree node = inorderPredecessorUtil(root, key);
        return node.data;
    }

    private Tree inorderPredecessorUtil(Tree root, Tree key)
    {
        if(key.left != null){
            return findMinimum(root.left);
        }

        Tree predecessor = null;

        while(root != null){
            if(root.data < key.data){
                predecessor = root;
                root = root.right;
            }else if(root.data > key.data){
                root = root.left;
            }else{
                break;
            }
        }
        return predecessor;
    }

    private Tree findMinimum(Tree node)
    {
        Tree curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr;
    }

    public static void main(String args[]){
        InorderPredecessor tree = new InorderPredecessor();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(25);
        tree.insert(13);
        tree.insert(14);
        tree.insert(12);

        int data = tree.inorderPredecessor(tree.root.left.right.left); // 4
        System.out.println(data);
    }

}
//                  15
//                /  \
//              10     20
//            /  \      \
//           5    13     25
//               /  \
//             12   14

