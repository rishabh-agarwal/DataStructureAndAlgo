package leetcode;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int n = board[0].length;
        int m = board[1].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(word.charAt(0) == board[i][j]){}
            }
        }

        return false;
    }
}
