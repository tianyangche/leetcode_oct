public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        if (haystack == null || haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        
        
        int i = 0;
        int j = 0;
        
        for (i = 0; i <= haystack.length() - needle.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}