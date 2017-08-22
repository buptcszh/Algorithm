class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        
        // dp[i] = dp[i/2] + i%2
        // 右移一位后1的个数 + 最后一位是否是1
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        
        return dp;
    }
}