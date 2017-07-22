public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int maxProfit = 0;

        // 这道题可以用贪心，因为局部最优解不需要前面阶段求得的值
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }

        return maxProfit;
    }
}

public class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int[] hold = new int[prices.length];
        int[] free = new int[prices.length];

        hold[0] = -prices[0];
        free[0] = 0;

        for (int i = 1; i < prices.length; i++) {

            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i]);
        }

        return free[prices.length - 1];
    }
}
