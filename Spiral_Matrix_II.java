public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int beginX = 0;
        int endX = n - 1;
        int beginY = 0;
        int endY = n - 1;
        int count = 1;
        while (true) {
            for (int i = beginX; i <= endX; i++) {
                res[beginY][i] = count++;
            }
            if (++beginY > endY) {
                return res;
            }
            for (int i = beginY; i <= endY; i++) {
                res[i][endX] = count++;
            }
            if (--endX < beginX) {
                return res;
            }
            for (int i = endX; i >= beginX; i--) {
                res[endY][i] = count++;
            }
            if (--endY < beginY) {
                return res;
            }
            for (int i = endY; i >= beginY; i--) {
                res[i][beginX] = count++;
            }
            if (++beginX > endX) {
                return res;
            }
        }
    }
}