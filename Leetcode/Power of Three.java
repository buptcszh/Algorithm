public class Solution {
    public boolean isPowerOfThree(int n) {
        return Math.log10(n) / Math.log10(3) % 1 == 0;  // 模1判断是否为整数
    }
}
