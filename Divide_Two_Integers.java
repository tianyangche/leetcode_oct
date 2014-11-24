public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean isDifferent = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int res = 0;
        
        while (a >= b) {
            int rotate = 0;
            while ((b << rotate) <= a) {
                rotate++;
            }
            res += 1 << (rotate - 1);
            a -= b << (rotate - 1);
        }
        return isDifferent ? -res : res;
    }
}