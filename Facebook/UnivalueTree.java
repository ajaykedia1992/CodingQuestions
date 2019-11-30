package Facebook;

public class UnivalueTree
{
    class UnivaluePackage{
        int count;
        boolean isUnival;
        UnivaluePackage(int count, boolean isUnival){
            this.count = count;
            this.isUnival = isUnival;
        }
    }

    public static void main(String args[]){
        Tree root = new Tree(2);
        root.left = new Tree(2);
        root.right = new Tree(2);
        root.right.left = new Tree(3);
        root.right.right = new Tree(4);

        int count = new UnivalueTree().getUnivalueTreeCount(root);
        System.out.println(count);
    }

    private int getUnivalueTreeCount(Tree root)
    {
        if(root == null){
            return 1;
        }

        UnivaluePackage up = getUnivalueTreeCountUtil(root);

        return up.count;
    }

    private UnivaluePackage getUnivalueTreeCountUtil(Tree root)
    {
        if(root == null){
            return new UnivaluePackage(0, true);
        }

        UnivaluePackage leftUnival = getUnivalueTreeCountUtil(root.left);
        UnivaluePackage rightUnival = getUnivalueTreeCountUtil(root.right);
        boolean isUnival = true;
        if(!leftUnival.isUnival && !rightUnival.isUnival){
            isUnival = false;
        }
        if(root.left != null && root.left.data != root.data){
            isUnival = false;
        }
        if(root.right != null && root.right.data != root.data){
            isUnival = false;
        }
        if(isUnival){
            return new UnivaluePackage(leftUnival.count + rightUnival.count + 1, true);
        }else{
            return new UnivaluePackage(leftUnival.count + rightUnival.count,  false);
        }
    }
}
