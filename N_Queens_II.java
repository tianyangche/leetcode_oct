public class Solution {
    private int res;
    public int totalNQueens(int n) {
        res = 0;
        if (n <= 1) {
            return n;
        }
        int[] pos = new int[n];
        Arrays.fill(pos, 0);
        helper(pos, 0);
        return res;
    }
    private void helper(int[] pos, int index) {
        if (index == pos.length) {
            res++;
            return;
        }
        
        for (int i = 1; i <= pos.length; i++) {
            pos[index] = i;
            if (isValid(pos, index)) {
                helper(pos, index + 1);
            }
        }
    }
    private boolean isValid(int[] pos, int index) {
        for (int i = 1; i <= index; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pos[i] == pos[j] || Math.abs(i - j) == Math.abs(pos[i] - pos[j])) {
                    return false;
                }
            }
        }
        return true;
    }
    private String[] convert(int[] pos) {
        String[] res = new String[pos.length];
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            for (int j = 1; j <= res.length; j++) {
                if (pos[i] == j) {
                    buffer.append('Q');
                } else {
                    buffer.append('.');
                }
            }
            res[i] = buffer.toString();
            buffer = new StringBuffer();
        }
        return res;
    }
}