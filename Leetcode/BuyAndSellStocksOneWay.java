package Leetcode;

public class BuyAndSellStocksOneWay {
    public static void main(String args[]){
        int[] stock = {1,3,6,2,5,0,10};
        int maxProfit = new BuyAndSellStocksOneWay().getMaxProfits(stock);
        System.out.println(maxProfit);
    }

    private int getMaxProfits(int[] stock) {
        if(stock == null || stock.length == 0){
            return 0;
        }

        int minimumStockPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < stock.length; i++){
            if(minimumStockPrice > stock[i]){
                minimumStockPrice = stock[i];
            }else if(stock[i] - minimumStockPrice > maxProfit){
                maxProfit = stock[i] - minimumStockPrice;
            }
        }
        return maxProfit;
    }
}
