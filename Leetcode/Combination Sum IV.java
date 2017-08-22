class Solution {
    private int[] dp;  // 直接递归会超时，改用dp的memo法
    
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);  // -1表示之前没有计算过
        dp[0] = 1;
        
        return recursion(nums, target);
    }
    
    private int recursion(int[] nums, int target) {
        if (dp[target] != -1) return dp[target];  // 如果计算过就直接返回
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                sum += recursion(nums, target - nums[i]);
            }
        }
        
        dp[target] = sum;  // 计算过的记录下来
        return sum;
    }
}