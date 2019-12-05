package Facebook.Test;

class TreeNode
{
    TreeNode left;
    TreeNode right;

    public TreeNode()
    {
        this.left = null;
        this.right = null;
    }
}


class Solution
{
    public static void main(String args[])
    {
        int[] nums = {10, 23, 20, 18, 28};
        Solution s = new Solution();
        int maxXor = s.getMaxXor(nums);
        System.out.println(maxXor);
    }

    private int getMaxXor(int[] nums)
    {

        TreeNode head = new TreeNode();

        for (int i = 0; i < nums.length; i++) {
            insert(nums[i], head);
        }

        return maxXorHelper(nums, head);
    }

    private void insert(int n, TreeNode head)
    {

        TreeNode curr = head;

        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;
            if (bit == 0) {
                if (curr.left == null) {
                    curr.left = new TreeNode();
                }
                curr = curr.left;
            }
            else {
                if (curr.right == null) {
                    curr.right = new TreeNode();
                }
                curr = curr.right;
            }
        }
    }

    private int maxXorHelper(int[] nums, TreeNode head)
    {

        int maxXor = Integer.MIN_VALUE;

        for (int n : nums) {
            int currXor = 0;
            TreeNode curr = head;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;

                if (bit == 0) {
                    if (curr.right != null) {
                        currXor += (1 << i);
                        curr = curr.right;
                    }
                    else {
                        curr = curr.left;
                    }
                }
                else {
                    if (curr.left != null) {
                        currXor += (1 << i);
                        curr = curr.left;
                    }
                    else {
                        curr = curr.right;
                    }
                }

            }

            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
