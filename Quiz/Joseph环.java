public class Joseph {
    // 求圆圈中最后剩下的数字
    public static void main(String[] args) {
        System.out.println(Joseph.find(5, 2));
    }

    public static int find(int n, int m) {
        // 假设编号从0开始
        int res = 0;
        for (int i = 2; i <= n; i++) {
            // f[i]表示剩下i个人时，最后留下的那个人的编号
            // 递推关系为f[i] = (f[i-1] + m) % i
            res = (res + m) % i;
        }

        return res;
    }
}

// n = 7, m = 3
// 0 1 2 3 4 5 6
//
// 3 4 5 6 0 1
// 0 1 2 3 4 5 重新编号
// origin = (cur + m) mod n;