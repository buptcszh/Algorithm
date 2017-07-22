public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        // 分解因子, 当且仅当因子中出现一对(2,5)时, 最后结果会增加一个零
        // 但2的个数永远多于5的个数，所以只需要计算5的个数即可
        while (n > 0) {
            // 如100/5=20，说明100的因子里有20个5的倍数
            // 但是25里包含两个5，因此25的倍数会增加两个零，因此遇到25的倍数时需要再加一次
            // 125...以此类推
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
