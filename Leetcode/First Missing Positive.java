public class Solution {
    public int firstMissingPositive(int[] nums) {
        // 因为正数从1开始，该方法可以找到从0开始第一个缺失的数，因此做如下转换
        for (int i = 0; i < nums.length; i++) {
            nums[i]--;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] >= 0 && nums[i] <= nums.length - 1 && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i + 1;
        }

        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
