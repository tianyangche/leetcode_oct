public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }     
        int m = S.length();
        int n = T.length();
        int[][] nums = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            nums[i][0] = 1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[m][n];
    }
}