class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = nums[0];
        int temp = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (temp < 0) temp = nums[i];
            else temp += nums[i];
            
            max = Math.max(max, temp);
        }
        
        return max;
    }
}