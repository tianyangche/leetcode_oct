public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            while ( i < j && !isValid(s.charAt(i))) {
                i++;
            }
            
            if (i >= j) {
                return true;
            }
            
            while (j > i && !isValid(s.charAt(j))) {
                j--;
            }
            
            if (i >= j) {
                return true;
            }
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
        
    }
    
    private boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}