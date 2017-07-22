public class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.lenth == 0) return 0;
        int n = nums.length;

        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        // dp[i]表示以i结尾的LIS
        // dp[i] = max{dp[j] + 1}, j=0,1,...i-1
        // 最后取最大的dp[i]
        for (int i = 0; i < n; i++) {

            dp[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
