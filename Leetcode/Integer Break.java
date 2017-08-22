class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        
        // 由于n是求解目标，因此不要将dp[n]初始化，因为n一定会被拆成两部分的乘积
        // 但小于n的数要被初始化成这个数本身，表示不进行拆分的结果【trick】
        for (int i = 1; i < n; i++) {
            dp[i] = i;
        }
        
        for (int i = 2; i <= n; i++) {
            // 超过i/2的部分就不用再计算了，因为dp[j]*dp[i-j] = dp[i-j]*dp[j]
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        
        return dp[n];
    }
}