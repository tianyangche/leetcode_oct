public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 1; i <= n; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
    }
}