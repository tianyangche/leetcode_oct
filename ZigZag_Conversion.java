public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.isEmpty() || nRows == 1) {
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < nRows; i++) {
            if (i == 0) {
                for (int j = 0; j < s.length(); j += 2 * nRows - 2) {
                    buffer.append(s.charAt(j));
                }
            } else if (i == nRows - 1) {
                for (int j = i; j < s.length(); j += 2 * nRows - 2) {
                    buffer.append(s.charAt(j));
                }
            } else {
                int count = 0;
                int j = i;
                while (j < s.length()) {
                    buffer.append(s.charAt(j));
                    if (count % 2 == 0) {
                        j += 2 * (nRows - i - 1);     
                    } else {
                        j += 2 * i;
                    }
                    count++;
                }
            }
        }
        return buffer.toString();
        
    }
}