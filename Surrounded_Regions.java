public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                queue.offer(i);
            }
            if (board[m - 1][i] == 'O') {
                queue.offer((m - 1) * n + i);
            }            
        }
        
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(i * n);
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(i * n + n - 1);
            }            
        }        
        
        while (!queue.isEmpty()) {
            int i = queue.peek() / n;
            int j = queue.poll() % n;
            board[i][j] = 'D';
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                queue.offer((i - 1) * n + j);
            }
            if (i + 1 < m && board[i + 1][j] == 'O') {
                queue.offer((i + 1) * n + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                queue.offer(i * n + j - 1);
            }
            if (j + 1 < n && board[i][j + 1] == 'O') {
                queue.offer(i * n + j + 1);
            }            
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}