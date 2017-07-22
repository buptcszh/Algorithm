// 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<')
// 使其成为一个合法的不等式数列。但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),
// 度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {

            dp[i][0] = 1;
        }

        // dp(i, j)表示前i个数的排列中，恰有j个小于号的方案数
        // dp(i, j) = dp(i-1, j-1)*(i-j) + dp(i-1, j)*(j-1)
        // 那么插入一个数后，有可能引入一个小于号，也有可能引入一个大于号
        // 如果引入一个小于号：那么有可能插入在队尾，或插入在任意一个大于号前面
        // 如果引入一个大于号：那么有可能插入在队头，或插入在任意一个小于号前面
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                dp[i][j] = (dp[i - 1][j - 1]*(i - j) + dp[i - 1][j]*(j + 1)) % 2017;
            }
        }

        System.out.println(dp[n][k]);
    }
}
