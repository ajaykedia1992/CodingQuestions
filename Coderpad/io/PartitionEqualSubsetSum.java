package Coderpad.io;

public class PartitionEqualSubsetSum
{
    public static void main(String args[]){
        int[] arr = {1, 5, 11, 5};
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        boolean isPartition = p.getPartitionEqualSubsetSum(arr);
        System.out.println(isPartition);
        System.out.println(p.getPartitionEqualSubsetSum1(arr));
    }

    private boolean getPartitionEqualSubsetSum(int[] arr)
    {
        if(arr == null || arr.length == 0){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        return getPartitionEqualSubsetSumHelper(arr, target, 0);
    }

    private boolean getPartitionEqualSubsetSumHelper(int[] arr, int target, int start)
    {
        if(target == 0){
            return true;
        }
        if(target < 0) return false;

        if(start >= arr.length){
            return false;
        }

        if(getPartitionEqualSubsetSumHelper(arr, target - arr[start],  start + 1)){
            return true;
        }

        int j = start + 1;
        while(j < arr.length && arr[j] == arr[j - 1]){
            j++;
        }
        return getPartitionEqualSubsetSumHelper(arr, target, j);
    }

    private boolean getPartitionEqualSubsetSum1(int[] arr){
        if(arr == null || arr.length == 0){
            return false;
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        boolean [] dp = new boolean[target + 1];
        dp[0] = true;

        return getPartitionEqualSubsetSumHelper1(arr, dp, target);
    }

    private boolean getPartitionEqualSubsetSumHelper1(int[] nums, boolean[] dp, int target)
    {
       for(int num : nums) {
           for (int i = target; i >= 0; i--) {
               if(i >= num){
                   dp[i] = dp[i] | dp[i - num];
               }
           }
       }

        return dp[target];
    }
}
