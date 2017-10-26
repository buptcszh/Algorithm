public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {  // 不能用n>0，因为n有可能是1<<32
            n = n & (n - 1);  // 消除最右边的1
            res++;
        }
        return res;
    }
}