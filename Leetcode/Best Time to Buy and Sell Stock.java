public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        // dp[i]表示第i天所能获得的最大收益
        int[] dp = new int[prices.length];

        dp[0] = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {

            min = Math.min(min, prices[i]);
            // dp[i]的状态只与dp[i-1]有关，因此可以用一个变量保存，优化空间复杂度
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }

        return dp[prices.length - 1];
    }
}
