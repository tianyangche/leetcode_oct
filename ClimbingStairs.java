public class Solution {
    
    // Time: O(n), Space: O(1)
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        
        int prev = 1;
        int curr = 1;
        
        // curr served as f[i - 1], prev served as f[i - 2].
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        
        return curr;
    }
}