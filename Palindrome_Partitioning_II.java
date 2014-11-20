public class Solution {
    public int minCut(String s) {
        if (s.length() < 2) {
            return 0;
        }
        
        int n = s.length();
        boolean[][] flag = isPalindrome(s);
        int[] f = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (flag[0][i]) {
                f[i] = 0;
            } else {
                f[i] = i + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (flag[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
    
    
    private boolean[][] isPalindrome(String str) {
        int n = str.length();
        boolean[][] flag = new boolean[n][n];
        for (boolean[] row : flag) {
            Arrays.fill(row, false);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if ( i == j || ((i - j == 1) && str.charAt(i) == str.charAt(j)) || (str.charAt(i) == str.charAt(j) && flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                } else {
                    flag[j][i] = false;
                }
            }
        }
        return flag;
    }
}