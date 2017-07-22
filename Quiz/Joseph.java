public class Joseph {

    public static void main(String[] args) {

        System.out.println(Joseph.find(5, 2));
    }

    public int find(int n, int m) {

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