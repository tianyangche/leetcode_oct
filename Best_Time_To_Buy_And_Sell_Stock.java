public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int low = Integer.MAX_VALUE;
        int curr = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(prices[i], low);
            curr = Math.max(curr, prices[i] - low);
        }
        return curr;
    }
}