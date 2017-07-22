public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int[] hold = new int[prices.length];  // hold[i]表示第i天持有股票时的最大利润
        int[] free = new int[prices.length];  // free[i]表示第i天未持有股票时的最大利润

        hold[0] = -prices[0];
        hold[1] = Math.max(-prices[0], -prices[1]);
        free[0] = 0;
        free[1] = Math.max(free[0], hold[0] + prices[1]);

        for (int i = 2; i < prices.length; i++) {

            // 第i天持有股票可能是因为昨天也持有股票，或者是因为前天卖出后今天买入了股票
            hold[i] = Math.max(hold[i-1], free[i-2] - prices[i]);
            // 第i天未持有股票可能是因为昨天也未持有股票，或者是因为今天卖出了股票
            free[i] = Math.max(free[i-1], hold[i-1] + prices[i]);
        }

        return free[prices.length - 1];
    }
}
