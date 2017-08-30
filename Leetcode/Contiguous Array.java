class Solution {
    public int findMaxLength(int[] nums) {
        // 把0替换成-1，这样问题就转化成求和为0的子数组的最大长度
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            Integer temp = map.get(sum);
            if (temp != null) {
                res = Math.max(res, i - temp);
            }
            else {
                map.put(sum, i);
            }
        }
        
        return res;
    }
}