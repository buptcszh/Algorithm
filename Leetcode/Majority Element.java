public class Solution {
    public int majorityElement(int[] nums) {

        // Boyer-Moore Majority Vote Algorithm
        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == major) count++;
            else if (count > 0) count--;
            else {

              major = nums[i];
              count++;
            }
        }

        return major;
    }
}
