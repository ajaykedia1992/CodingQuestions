/*
https://www.geeksforgeeks.org/coin-change-dp-7/
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6},
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
package DynamicProgramming;

public class CoinChange
{
    public static void main(String args[]){
        int coins[] = {5, 10, 15};
        int money = 20;
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
