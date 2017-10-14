public class Solution {
    public int[] singleNumber(int[] nums) {
        //  求出这两个数的异或值
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 只保留二进制中最右边的1
        int bit = xor & -xor;

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
