public class Solution {
    public int[] singleNumber(int[] nums) {
        //  求出这两个数的异或值
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 求异或值bit位中最右边的1的位置
        int bit = xor & -xor;  // 求负数的补码：最右边的1及其后边的bit不变，前边的取反

        int[] res = {0, 0};
        for (int num : nums) {
            // 根据这个bit把这些数分成两组
            if ((num & bit) == 0) {
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
