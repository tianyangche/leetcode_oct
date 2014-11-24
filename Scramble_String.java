public class Solution {
    public boolean isScramble(String s1, String s2) {
        int N = s1.length();
        if (s2.length() != N) {
            return false;
        }
        boolean result[][][] = new boolean[N+1][N][N];
        for (int i = 0; i <= N;i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j][k]=false;                       
                }
            }
        }

        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[1][i][j] = (s1.charAt(i) == s2.charAt(j) );
            }
        }
        for (int n = 2; n <= N; n++){
            for (int i = 0; i <= N - n; i++){
                for (int j = 0; j <= N - n; j++){
                    for (int k = 1; k < n; k++){
                        if (  (result[k][i][j] && result[n-k][i+k][j+k])
                            ||(result[k][i][j+n-k] && result[n-k][i+k][j])) {
                              result[n][i][j] = true;
                              break;
                          }
                    }
                }
            }
        }
        return result[N][0][0];
    }
}