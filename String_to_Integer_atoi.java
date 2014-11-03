public class Solution {
    public int atoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        
        int sign = 1;
        long value = 0;
        int index = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = str.charAt(0) == '-' ? -1 : 1;
            index++;
        }
        
        while (index < str.length()) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }
            value = value * 10 + (c - '0');
            if (value > Integer.MAX_VALUE) {
                break;
            }
            index++;
        }
        
        if (value > Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE;
        }
        if (value > Integer.MAX_VALUE && sign == -1) {
            return Integer.MIN_VALUE;
        }
        
        return (int)(value * sign);
    }
}