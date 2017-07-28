public class Solution {
    public int singleNumber(int[] nums) {
        // operations on different bits are independent of each other,
        // so we can merge them into one integer
        int x1 = 0, x2 = 0;  // 2 counters represents 3 states: 00->01->10->00
        int mask;  // cut to '00' when reaching '11'. mask = ~(x2 & x1), cus 3 = 0b11

        for (int num : nums) {

            // x3 ^= (x2 & x1 & num)
            x2 ^= (x1 & num);  // x2 changes when x1 and num are both 1
            x1 ^= num;

            mask = ~(x2 & x1);
            x2 &= mask;
            x1 &= mask;
        }

        return x1;  // x1 represents the single one
    }
}
