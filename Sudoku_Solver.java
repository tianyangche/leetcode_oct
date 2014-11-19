public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; k ++) {
                        board[i][j] = (char) ('0' + k);
                        if (isValid(board) && solve(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }        
        return true;
    }
    private boolean isValid(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            if (!checkRow(board, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i ++) {
            if (!checkCol(board, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (!checkSubBoard(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkRow(char[][] board, int row) {
        boolean[] flag = new boolean[9];
        Arrays.fill(flag, false);
        for (int i = 0; i < 9; i ++) {
            if (board[row][i] == '.') {
                continue;
            }
            char c = board[row][i];
            if (flag[c - '1']) {
                return false;
            }
            flag[c - '1'] = true;
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int col) {
        boolean[] flag = new boolean[9];
        Arrays.fill(flag, false);
        for (int i = 0; i < 9; i ++) {
            if (board[i][col] == '.') {
                continue;
            }
            char c = board[i][col];
            if (flag[c - '1']) {
                return false;
            }
            flag[c - '1'] = true;
        }
        return true;        
    }
    
    private boolean checkSubBoard(char[][] board, int row, int col) {
        boolean[] flag = new boolean[9];
        Arrays.fill(flag, false);
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                char c = board[3 * row + i][3 * col + j];
                if (c == '.') {
                    continue;
                }
                if (flag[c - '1']) {
                    return false;
                }
                flag[c - '1'] = true;
            }
        }
        return true;
    }
}