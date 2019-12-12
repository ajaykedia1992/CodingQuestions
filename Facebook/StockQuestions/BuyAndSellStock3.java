/*
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 */
package Facebook.StockQuestions;

import java.util.Arrays;

public class BuyAndSellStock3
{
    public static void main(String args[]){
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        int maxProfit = new BuyAndSellStock3().getMaxProfit(prices, k);
        System.out.println(maxProfit);
    }

    private int getMaxProfit(int[] prices, int k)
    {
        if(k == 0 || prices == null || prices.length == 0 || prices.length < 2) return 0;

        int increasingNumber = 0;

        int maxProfit = 0;
        boolean increasing = false;
        for(int  i = 1; i < prices.length; i++){
            int temp = prices[i] - prices[i - 1];
            if(temp > 0){
                increasingNumber += increasing ? 0 : 1;
                increasing = true;
                maxProfit += temp;
            }else{
                increasing = false;
            }
        }

        if(k >= increasingNumber) return maxProfit;

        int[] costs = new int[k + 1];
        int[] profits = new int[k + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        for(int p : prices){
            for(int i = 1; i <= k; i++){
                costs[i] = Math.min(costs[i], p - profits[i-1]); // Same as BuyAndSellStock2
                profits[i] = Math.max(profits[i],  p - costs[i]);
            }
        }
        return profits[k];
    }

}
