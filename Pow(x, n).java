public class Solution {
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            isNegative = true;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return isNegative ? 1 / (half * half) : half * half;
        } else {
            return isNegative ? 1 / (half * half * x) : half * half * x;
        }
    }
}