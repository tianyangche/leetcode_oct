public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int one = 1;
        int two = 1;
        int ways = 1;
        for (int i = 1; i < s.length(); i++) {
            ways = 0;
            if (s.charAt(i) != '0') {
                ways += one;
            }
            int value = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (value >= 10 && value <= 26) {
                ways += two;
            }
            two = one;
            one = ways;
        }
        
        return ways;
        
        
        
    }
}