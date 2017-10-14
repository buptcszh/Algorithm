public class Solution {
	public int missingNumber(int[] nums) {
		int res = nums.length;  // n
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}
