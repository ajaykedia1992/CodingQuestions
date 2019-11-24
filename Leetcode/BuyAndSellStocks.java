package Leetcode;

public class BuyAndSellStocks {
    public static void main(String args[]){
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        int fee = 0;
        double maxProfit = new BuyAndSellStocks().getMaxProfit(prices, fee);
        System.out.println(maxProfit);
    }

    private double getMaxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        // s0 -> selling s1 -> buying
        double s0 = 0, s1 = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            int stock = prices[i];
            double temp = s0;
            s0 = Math.max(s0, s1 + stock);
            s1 = Math.max(s1, temp -stock -fee);
        }
        return s0;
    }
}
