public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp < 0) {
                    j++;
                    while (nums[j] == nums[j-1] && j < k) j++;
                }
                else if (temp > 0) {
                    k--;
                    while (nums[k] == nums[k+1] && j < k) k--;
                }
                else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j] == nums[j-1] && nums[k] == nums[k+1] && j < k) {
                        j++;
                        k--;
                    }
                }
            }
        }

        return res;
    }
}
