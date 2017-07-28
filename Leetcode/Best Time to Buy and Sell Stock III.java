public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[] f = new int[n];  // f[i]表示到第i天为止，可以获得的最大利润
        int[] g = new int[n];  // g[i]表示从第i天开始，可以获得的最大利润

        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - min);
        }

        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            g[i] = Math.max(g[i + 1], max - prices[i]);
        }

        int res = 0;
        // 进行2次交易的情况
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, f[i] + g[i + 1]);
        }
        // 进行1次交易的情况
        res = Math.max(res, f[n - 1]);

        return res;
    }
}
