package Glider.io;

public class MaximumSumOfDigit
{
        public static void main(String[] args) {
            long max = 100;
            tomsNum(max);
        }

    private static void tomsNum(long max)
    {
        long maxValue = findMax(max);
        System.out.println(maxValue);
    }

    private static long findMax(long max)
    {
        if(max == 0){
            return 0;
        }
        int b = 1;
        long ans = max;
        while(max > 0){
            long curr = (max - 1) * b + (b - 1);
            long sumCurr =  maxSum(curr);
            long sumMax = maxSum(ans);
            if((sumCurr> sumMax)|| (sumCurr == sumMax && curr > ans) ){
                ans = curr;
            }
            max /= 10;
            b *= 10;
        }
        return ans;
    }

    private static long maxSum(long curr)
    {
        long sum = 0;
        while(curr != 0){
            long val = curr % 10;
            sum += val;
            curr /= 10;
        }
        return sum;
    }
}


