public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] flag = new boolean[9];
        for(int i = 0; i < 9; i ++){
            Arrays.fill(flag, false);
            for(int j = 0; j < 9; j ++){
                if(!check(board[i][j], flag))
                    return false;
            }
            Arrays.fill(flag, false);
            for(int j = 0; j < 9; j ++){
                if(!check(board[j][i], flag))
                    return false;
            }
        }
        
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                Arrays.fill(flag, false);
                for(int m = 0; m < 3; m ++){
                    for(int n = 0; n < 3; n ++){
                        if(!check(board[i*3 + m][j*3 + n], flag))
                            return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check(char c, boolean[] flag){
        if(c == '.')
            return true;
        int pos = c - '1';
        if(flag[pos])
            return false;
        flag[pos] = true;
            return true;
    }

    
}

