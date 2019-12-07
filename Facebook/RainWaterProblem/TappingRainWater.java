package Facebook.RainWaterProblem;

import java.util.Stack;

public class TappingRainWater
{
    public static void main(String args[]){
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TappingRainWater t = new TappingRainWater();
        int maxWaterStore = t.getMaxWater(height);
        System.out.println(maxWaterStore);
        System.out.println(t.getMaxWater1(height));
    }

    private int getMaxWater(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        for(int i = 0; i < n; i++){
            if(left[i] == 0 || right[i] == 0){
                continue;
            }
            int spaceAvailable = Math.min(left[i], right[i]) - height[i];
            if(spaceAvailable < 0){
                continue;
            }
            ans += spaceAvailable;
        }
        return ans;
    }

    private int getMaxWater1(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else if(height[i] <= height[stack.peek()]){
                stack.push(i);
            }else{
                int top = stack.pop();
                while(!stack.isEmpty() && height[top] == height[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }

                int stackTop = stack.peek();

                int waterNeedToBeFilled = (Math.min(height[i], height[stackTop]) - height[top]) * (i - stackTop - 1);

                ans += waterNeedToBeFilled;
                i -= 1;
            }
        }
        return ans;
    }
}
