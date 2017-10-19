class Solution {
    // 由于数字出现3次，因此对于数字的每个bit，可以定义3种状态及其转移规则：00->01->10
    // 将各个bit合在一起，则可以使用两个int型的计数器来表示
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;  // 当twos为0时，ones才进1；否则置为0
            twos = (twos ^ num) & ~ones;  // 当改变后的ones为0时，twos才进1；否则置0
        }
        return ones;
    }
}