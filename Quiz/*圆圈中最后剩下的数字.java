public class Solution {
    public int LastRemaining_Solution(int n, int m) {

        if (n < 1 || m < 1) return -1;

        // 只有一个人时，最后剩下的人的编号为0
        int last = 0;
        for (int i = 2; i <= n; i++) {

            // 当有i个人时，当前编号与原编号的映射关系为(last+m)%i
            last = (last + m) % i;
        }

        return last;
    }
}

// n = 7, m = 3
// 0 1 2 3 4 5 6
//
// 3 4 5 6 0 1
// 0 1 2 3 4 5 重新编号
// origin = (cur + m) mod n;
