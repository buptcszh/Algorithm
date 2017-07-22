public class Solution {
    private int[] s;

    public NumArray(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            nums[i] += nums[i-1];
        }
        s = nums;
    }

    public int sumRange(int i, int j) {

        if (i == 0) return s[j];

        return s[j] - s[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
