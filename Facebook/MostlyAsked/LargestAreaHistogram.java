package Facebook.MostlyAsked;

import java.util.Stack;

public class LargestAreaHistogram
{
    public static void main(String args[])
    {
        int histogram[] = {2,2,2,6,1,5,4,2,2,2,2};
        int area = new LargestAreaHistogram().getLargestArea(histogram);
        System.out.print(area);
    }

    private int getLargestArea(int[] histogram)
    {
        if (histogram == null || histogram.length == 0) {
            return 0;
        }

        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i;
        for (i = 0; i < histogram.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            else if (histogram[i] >= histogram[stack.peek()]) {
                stack.push(i);
            }

            else {
                int cursor = stack.pop();
                int area = 0;
                while (!stack.isEmpty() && histogram[cursor] == histogram[stack.peek()]) {
                    stack.pop();
                }

                if(stack.isEmpty()){
                    area += histogram[cursor] * i;
                }else {
                    area = histogram[cursor] * (cursor - stack.peek());
                }
                maxArea = Math.max(area, maxArea);
                i -= 1;
            }
        }

        while(!stack.isEmpty()){
            int cursor = stack.pop();
            int area = 0;
            while (!stack.isEmpty() && histogram[cursor] == histogram[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                area += histogram[cursor] * i;
            }else {
                area = histogram[cursor] * (cursor - stack.peek());
            }
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
