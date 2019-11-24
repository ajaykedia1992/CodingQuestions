package ByteByByte;

import java.util.Arrays;

public class MinimumCoinChange
{
    public static void main(String args[]){
        int coins[] = {10, 6, 1};
        int value = 15;

        int count = MinimumCoinChange.getMinimumCoinsCount(coins, value);
        System.out.println(count);
    }

    private static int getMinimumCoinsCount(int[] coins, int value)
    {
        int cache[] = new int[value + 1];
        Arrays.fill(cache, -1);
        return getMinimumCoinsCountUtil(coins, value, cache);
    }

    private static int getMinimumCoinsCountUtil(int[] coins, int value, int[] cache)
    {
        if(cache[value] >= 0){
            return cache[value];
        }
        if(value == 0){
            return 0;
        }

        int minimumCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int c = value - coins[i];
            if(c >= 0 ){
                int currentCoins = getMinimumCoinsCountUtil(coins, c, cache);
                if(minimumCoins > currentCoins){
                    minimumCoins = currentCoins;
                }
            }
        }

        cache[value] = minimumCoins + 1;
        return cache[value];
    }
}
