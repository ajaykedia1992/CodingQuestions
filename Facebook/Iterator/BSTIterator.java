package Facebook.Iterator;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    List<Integer> arrayList;
    int index;

    public BSTIterator(Tree root) {
        arrayList = new ArrayList<Integer>();
        index = -1;
        insertData(root);
    }

    public void insertData(Tree root){

        if(root != null){
            insertData(root.left);
            arrayList.add(root.data);
            insertData(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        return arrayList.get(++index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index + 1 < arrayList.size();
    }
}
