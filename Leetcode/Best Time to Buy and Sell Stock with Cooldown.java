public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];

        hold[0] = -prices[0];
        hold[1] = -Math.min(prices[0], prices[1]);

        free[0] = 0;
        free[1] = Math.max(free[0], hold[0] + prices[1]);

        for (int i = 2; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 2] - prices[i]);  // cooldown
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i]);
        }

        return free[n - 1];
    }
}
