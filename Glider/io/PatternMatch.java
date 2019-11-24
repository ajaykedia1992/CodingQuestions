package Glider.io;

public class PatternMatch
{
    static int R;
    static int C;

    static int[] X = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] Y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String args[])
    {
        R = 3;
        C = 13;

        char[][] grid = {{'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S'},
                {'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K'},
                {'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E'}};
        patternSearch(grid, "GEEKS");
        System.out.println();
        patternSearch(grid, "EEE");
    }

    private static void patternSearch(char[][] grid, String word)
    {
        for (int row = 0; row < R; row++)
        {
            for (int col = 0; col < C; col++)
            {
                if (patternSearchUtil(grid, word,  row, col))
                    System.out.println("pattern found at " + row +
                            ", " + col);
            }
        }

    }

    private static boolean patternSearchUtil(char[][] grid, String word, int row, int col)
    {
        if (grid[row][col] != word.charAt(0)) {
            return false;
        }
        // Total 8 directions
        for (int dir = 0; dir < 8; dir++) {
            int rd = row + X[dir];
            int cd = col + Y[dir];
            int j;
            for (j = 1; j < word.length(); j++) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0) {
                    break;
                }
                if (grid[rd][cd] != word.charAt(j)) {
                    break;
                }
                rd += X[dir];
                cd += Y[dir];
            }
            if(j == word.length())
                return true;
        }
        return false;
    }
}
