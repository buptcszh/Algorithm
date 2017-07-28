public class Solution {
    public int maxProfit(int[] prices) {
        // 每天有三种状态：买入、不变、卖出
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        // 到第i天为止，持有股票时的最大利润
        // 可能是前一天就持有股票，也可能是第i天才买入
        int[] hold = new int[n];
        // 到第i天为止，未持有股票时的最大利润
        // 可能是前一天就未持有股票，也可能是第i天才卖出
        int[] free = new int[n];

        hold[0] = -prices[0];
        free[0] = 0;

        for (int i = 1; i < n; i++) {

            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i]);
        }

        return free[n - 1];
    }
}
