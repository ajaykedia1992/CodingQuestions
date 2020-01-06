/*
https://www.geeksforgeeks.org/optimal-strategy-for-a-game-set-2/
Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns.
In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
Determine the maximum possible amount of money we can definitely win if we move first.
Note: The opponent is as clever as the user.
Let us understand the problem with few examples:
1. 5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
2. 8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)
 */
package DynamicProgramming;

public class OptimalGameStrategy
{
    public static void main(String args[]){
        int game[] = {8, 5, 13, 7};
        System.out.println(new OptimalGameStrategy().getMax(game));
    }
    private int getMax(int[] game)
    {
        if(game == null || game.length == 0) return 0;

        int sum = 0;
        for(int i : game) {
            sum += i;
        }
        int [][] memo = new int[sum][sum];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[0].length; j++)
                memo[i][j] = -1;
        return helper(game, 0, game.length - 1, sum, memo);
    }

    private int helper(int[] game, int i, int j, int sum, int[][] memo)
    {
        if(i + 1 == j){
            return Math.max(game[i], game[j]);
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        memo[i][j] = Math.max(sum - helper(game, i + 1, j, sum - game[i], memo), sum - helper(game, i, j - 1, sum - game[j], memo));
        return memo[i][j];
    }
}
