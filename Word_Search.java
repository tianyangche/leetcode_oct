public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean res =  helper(board, i - 1, j, word, pos + 1) || helper(board, i + 1, j, word, pos + 1)
                    || helper(board, i, j + 1, word, pos + 1) || helper(board, i, j - 1, word, pos + 1);
        board[i][j] = temp;
        return res;
    }
}