public class Solution {
    public int maxSubArray(int[] nums) {

        // sum[i]表示以i结尾的最大子段和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 考虑sum[i-1]的正负，而不是nums[i]的正负
            if (sum[i-1] >= 0) sum[i] = sum[i-1] + nums[i];
            else sum[i] = nums[i];

            max = Math.max(max, sum[i]);
        }

        return max;
    }
}
