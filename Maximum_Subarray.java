public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (curr < 0) {
                curr = 0;
            }
            curr += A[i];
            max = Math.max(curr, max);
        }
        return max;
    }
}