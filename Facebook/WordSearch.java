/*
Given a 2D matrix with alphabets and you have to search for a word in that matrix. You can move all 4 directions
 */
package Facebook;

public class WordSearch
{
    public static void main(String args[]){
        Character[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        WordSearch w = new WordSearch();
        boolean isPresent = w.wordSearch(matrix, word);
        System.out.println(isPresent);
    }

    private boolean wordSearch(Character[][] matrix, String word)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == matrix[i][j]){
                    if(wordSearchHelper(matrix, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordSearchHelper(Character[][] matrix, String word, int i, int j, int index, boolean[][] visited)
    {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        if(index == word.length() - 1){
            return true;
        }
        visited[i][j] = true;
        if(wordSearchHelper(matrix, word, i + 1, j, index + 1, visited)) return true;
        if(wordSearchHelper(matrix, word, i - 1, j, index + 1, visited)) return true;
        if(wordSearchHelper(matrix, word, i, j + 1, index + 1, visited)) return true;
        if(wordSearchHelper(matrix, word, i, j - 1, index + 1, visited)) return true;
        return false;
    }
}
