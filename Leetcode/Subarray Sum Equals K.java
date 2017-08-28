class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;  // sum表示累加和
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // 如果sum=k的话，即0~当前位置的这段子数组的和为k，put(0,1)是为了表示这个结果
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);  // 在当前位置之前，有多少段子数组的和为sum-k
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}
// 2 sum