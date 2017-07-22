public class Solution {
    public int removeElement(int[] nums, int val) {
        
        if (nums == null || nums.length == 0) return 0;
        
        int start = 0, end = nums.length-1;
        while (start <= end) {
            
            if (nums[start] == val) {
                
                if (nums[end] == val) end--;
                else nums[start++] = nums[end--];
            }
            else start++;
        }
        return start;
    }
}