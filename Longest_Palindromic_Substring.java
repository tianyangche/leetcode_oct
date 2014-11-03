public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j == 0 || (i - j == 1 && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                    if (max < i - j + 1) {
                        max = Math.max(max, i - j + 1);
                        index = j;
                    }
                } else {
                    flag[j][i] = false;
                }
            }
        }
        return s.substring(index, index + max);
    }
}