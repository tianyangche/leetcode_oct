public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int fastest = 0;
        for (int i = 0; i <= fastest; i++) {
            fastest = Math.max(i + A[i], fastest);
            if (fastest >= A.length - 1) {
                return true;
            }
        }
        return false;
    }
}