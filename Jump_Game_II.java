public class Solution {
    public int jump(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int fastest = 0;
        int curr = 0;
        int step = 1;
        for (int i = curr; i <= fastest; i++) {
            curr = Math.max(curr, i + A[i]);
            if (curr >= A.length - 1) {
                return step;
            }
            if (i == fastest) {
                fastest = curr;
                step++;
            }
        }
        return -1;
    }
}