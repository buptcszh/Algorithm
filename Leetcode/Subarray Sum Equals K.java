class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // k!=0时，如果sum=k，为了考虑到0~i这一段，需要put<0,1>
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);  // 颠倒的话，k=0的结果会多1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}
// 2 sum