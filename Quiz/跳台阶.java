public class Solution {
    public int JumpFloor(int target) {

        if (target == 1) return 1;

        int a = 1, b = 2;
        for (int i = 3; i <= target; i++) {

            int temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }
}
