public class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
    }

    private int rob2(int[] nums, int start, int end) {

        if (start == end) return nums[start];

        int[] dp = new int[end - start + 1];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < end - start + 1; i++) {

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[end - start];
    }
}
