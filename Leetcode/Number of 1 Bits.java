public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {  // Java里没有无符号数，需要直接用位运算操作底层的bit位
        
        int sum = 0;
        while (n != 0) {  // 不能用n > 0
            
            sum += n & 1 ;  // 负数的模2运算和位运算不是等价的，原因如下
            n = n >>> 1;
        }
        
        return sum;
    }
}

// 计算a % b时，一般都会满足a = b * q + r
// q表示商，r表示余数。q = a / b，这个在不同的语言中有不同的处理方式，Java中采用趋零结尾
// 因此r = a - (a / b) * b，如-11 % 5 = -11 - (-2) * 5 = -1
// 因此Java中的规律是：取模运算结果的符号与第一个操作数的符号相同