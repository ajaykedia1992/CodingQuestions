package Facebook.MostlyAsked;

public class BestTimeToBuyAndSell
{
    public static void main(String args[])
    {
        int prices[] = {2, 5, 1, 3, 4, 5};
        System.out.print(new BestTimeToBuyAndSell().getMaxProfit(prices));
    }

    private int getMaxProfit(int[] prices)
    {
        int minPrice = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++) {
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
