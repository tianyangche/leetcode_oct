public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }    
        int power = 1;
        while (x / power >= 10) {
            power *= 10;
        }
        while (x != 0) {
            if (x / power != x % 10) {
                return false;
            }
            x = x % power / 10;
            power /= 100;
        }
        return true;
    }
}