/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
package Facebook.StockQuestions;

public class BuyAndSellStock
{
    public static void main(String [] args){
        int arr[] = {1, 8, 2, 10, 7, 0};
        int maxProfit = new BuyAndSellStock().getMaxProfit(arr);
        System.out.println(maxProfit);
    }

    private int getMaxProfit(int[] arr)
    {
        int minPrice = arr[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(minPrice > arr[i]){
                minPrice = arr[i];
            }else{
                maxProfit = Math.max(maxProfit, arr[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
