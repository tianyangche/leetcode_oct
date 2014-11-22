public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];
        flag[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            flag[i][0] = flag[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s2.length(); i++) {
            flag[0][i] = flag[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                flag[i][j] = (flag[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                             (flag[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return flag[s1.length()][s2.length()];
    }
}