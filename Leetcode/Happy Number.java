public class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            // 快慢指针。如果不是happy数，一定会陷入循环，慢指针会追上快指针
            slow = helper(slow);
            fast = helper(fast);
            fast = helper(fast);

            if (fast == 1) return true;
        } while (slow != fast);
        return false;
    }

    private int helper(int n) {
        int sum = 0;

        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        }

        return sum;
    }
}
