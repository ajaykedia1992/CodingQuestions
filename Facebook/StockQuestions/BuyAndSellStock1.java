/*
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
package Facebook.StockQuestions;

public class BuyAndSellStock1
{
    public static void main(String [] args){
        int arr[] = {1, 8, 2, 10, 7, 0};
        int maxProfit = new BuyAndSellStock1().getMaxProfit(arr);
        System.out.println(maxProfit);
    }

    private int getMaxProfit(int[] arr)
    {
        int maxProfit = 0;
        for(int i = 1; i < arr.length; i++){
            maxProfit += arr[i]>arr[i - 1] ? arr[i] - arr[i - 1] : 0;
        }
        return maxProfit;
    }
}
