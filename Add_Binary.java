public class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuffer res = new StringBuffer();
        
        while (m >= 0 || n >= 0) {
            int aa = m >= 0 ? a.charAt(m) - '0' : 0;
            int bb = n >= 0 ? b.charAt(n) - '0' : 0;
            int digit = (aa + bb + carry) % 2;
            res.append(digit);
            carry = (aa + bb + carry) / 2;
            m--;
            n--;
        }
        
        if (carry == 1) {
            res.append(1);    
        }
        return res.reverse().toString();
    }
}