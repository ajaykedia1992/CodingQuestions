package Facebook.CoinChange;

import java.util.Arrays;

public class CoinChange
{
    public static void main(String args[])
    {
        int[] coins = {25, 10, 5, 1};
        int price = 41;
        int countChange = new CoinChange().getMinCoinChange(coins, price);
        System.out.println(countChange);
    }

    private int getMinCoinChange(int[] coins, int price)
    {
        int cache[] = new int[price + 1];
        Arrays.fill(cache, -1);
        return getMinCoinChangeHelper(coins, cache, price);

    }

    private int getMinCoinChangeHelper(int[] coins, int[] cache, int price)
    {
        if (price == 0) {
            return 0;
        }
        int min = price;
        for (int p : coins) {
            int temp = price - p;
            if (temp >= 0) {
                int c;
                if (cache[temp] >= 0) {
                    c = cache[temp];
                }
                else {
                    c = getMinCoinChangeHelper(coins, cache, price - p);
                    cache[temp] = c;
                }
                if (min > c + 1) {
                    min = c + 1;
                }
            }
        }
        return min;
    }
}
