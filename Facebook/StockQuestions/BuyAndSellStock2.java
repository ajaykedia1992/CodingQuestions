/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
package Facebook.StockQuestions;

public class BuyAndSellStock2
{
    public static void main(String [] args){
        int arr[] = {1, 8, 2, 10, 7, 0};
        int maxProfit = new BuyAndSellStock2().getMaxProfit(arr);
        System.out.println(maxProfit);
    }

    public int getMaxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int buyOne = Integer.MAX_VALUE, buyTwo = Integer.MAX_VALUE, maxProfitOne = Integer.MIN_VALUE, maxProfitTwo = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            buyOne = Math.min(buyOne, prices[i]);
            maxProfitOne = Math.max(maxProfitOne, prices[i] - buyOne);

            buyTwo = Math.min(buyTwo, prices[i] - maxProfitOne);
            maxProfitTwo = Math.max(maxProfitTwo, prices[i] - buyTwo);
        }

        return maxProfitTwo;
    }
}
