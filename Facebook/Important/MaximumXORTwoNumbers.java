/*
https://www.youtube.com/watch?v=jCu-Pd0IjIA
 */
package Facebook.Important;

class TreeNode{
    TreeNode left;
    TreeNode right;

    TreeNode(){
        this.left = null;
        this.right = null;
    }
}

public class MaximumXORTwoNumbers
{
    public static void main(String args[]){
        int [] nums = {10,23,20,18,28};
        MaximumXORTwoNumbers m = new MaximumXORTwoNumbers();
        System.out.println(m.getMaximumXORTwoNumbers(nums));
    }

    private int getMaximumXORTwoNumbers(int[] nums)
    {
        TreeNode head = new TreeNode();
        for(int i = 0; i < nums.length; i++){
            insert(head, nums[i]);
        }
        
        return findMaxXORValue(head, nums);
    }

    private int findMaxXORValue(TreeNode head, int[] nums)
    {
        int maxXor = Integer.MIN_VALUE;
        for(int n : nums){
            TreeNode curr = head;
            int currXor = 0;
            for(int i = 31; i >= 0; i--){
                int bit = (n >> i) & 1;
                if(bit == 0){
                    if(curr.right != null){
                        currXor += (1 << i);
                        curr = curr.right;
                    }else{
                        curr = curr.left;
                    }
                }else{
                    if(curr.left != null){
                        currXor += (1 << i);
                        curr = curr.left;
                    }else{
                        curr = curr.right;
                    }
                }
            }
            if(currXor > maxXor){
                maxXor = currXor;
            }
        }
        return maxXor;
    }

    private void insert(TreeNode head, int value){
        TreeNode curr = head;
        for(int i = 31; i >= 0; i--){
            int bit = (value >> i) & 1;
            if(bit == 0){
                if(curr.left == null){
                    curr.left = new TreeNode();
                }
                curr = curr.left;
            }else{
                if(curr.right == null){
                    curr.right = new TreeNode();
                }
                curr = curr.right;
            }
        }
    }
}
