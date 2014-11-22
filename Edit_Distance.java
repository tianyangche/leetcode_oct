public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int[] row : f) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }
        return f[m][n];
    }
}