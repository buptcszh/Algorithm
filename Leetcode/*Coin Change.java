public class Solution {
    private static final int INF = 1 << 30;

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
								// 背包容量为0时，结果为0，即一个都不放
                dp[i][j] = INF;

				// 完全背包，一个物品可以放无限多个
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k * coins[i - 1] <= j; k++) {
										// 选k=0...j/coins[i]里的最小值
                    dp[i][j] = Math.min(dp[i - 1][j - k * coins[i - 1]] + k, dp[i][j]);
                }
            }
        }

        return min == INF ? -1 : min;
    }
}
