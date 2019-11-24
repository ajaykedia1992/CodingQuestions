package Leetcode;

public class MaxWaterContainer {

    public static void main(String args[]){
        int [] container = {1,7,2,4,9,3,1};
        int maxWaterStore = new MaxWaterContainer().getMaxWaterStoreValue(container);
        System.out.println(maxWaterStore);
    }

    private int getMaxWaterStoreValue(int[] container) {
        if(container == null || container.length == 0){
            return 0;
        }

        int l= 0, r = container.length - 1;
        int maxValue = Integer.MIN_VALUE;
        while(l < r){
            maxValue = Math.max(maxValue, Math.min(container[l], container[r]) * (r - l));
            if(container[l] < container[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxValue;
    }
}
