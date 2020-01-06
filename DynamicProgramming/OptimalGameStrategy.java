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
