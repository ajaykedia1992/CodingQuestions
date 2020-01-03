package DynamicProgramming;

public class CoinChange
{
    public static void main(String args[]){
        int coins[] = {1, 2, 3, 4};
        int money = 4;
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(coins, money));
    }

    private int coinChange(int[] coins, int money)
    {
        if(coins == null || coins.length == 0){
            return 0;
        }

        int dp[] = new int[money + 1];
        dp[0] = 1;
        for(int c : coins){
            for(int i = c; i <= money; i++){
                if(i <= money){
                    dp[i] += dp[i - c];
                }
            }
        }
        return dp[money];
    }
}
