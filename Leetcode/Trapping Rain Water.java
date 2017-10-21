class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        // 记录每个位置左边的最高值
        int[] left = new int[n];
        int lMax = 0;
        for (int i = 0; i < n; i++) {
            left[i] = lMax;
            lMax = Math.max(lMax, height[i]);
        }
        
        // 记录每个位置右边的最高值
        int[] right = new int[n];
        int rMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = rMax;
            rMax = Math.max(rMax, height[i]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = Math.min(left[i], right[i]) - height[i];
            if (x > 0) res += x;
        }
        return res;
    }
}