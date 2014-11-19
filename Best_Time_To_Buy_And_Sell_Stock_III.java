public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];
        Arrays.fill(f, 0);
        Arrays.fill(g, 0);
        
        for (int i = 1, valley = prices[0]; i < n; i++) {
            valley = Math.min(valley, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - valley);
        }
        
        for (int i = n - 2, peak = prices[n - 1]; i >= 0; i--) {
            peak = Math.max(peak, prices[i]);
            g[i] = Math.max(g[i + 1], peak - prices[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, f[i] + g[i]);
        }
        return max;
    }
}