// 定义如下规则序列(字符串)：
// 1．空序列是规则序列；
// 2．如果S是规则序列，那么(S)也是规则序列；
// 3．如果A和B都是规则序列，那么AB也是规则序列。
//
// a[i]表示第i个位置为左括号时的价值，b[i]表示第i个位置为右括号时的价值
// 求长度为2n的所有可能的规则序列的最大价值

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        n *= 2;

        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }

        int[][] dp = new int[n + 1][n + 2];
        // 很重要的初始化
        for (int i = 1; i <= n + 1; i++) {

            dp[0][i] = Integer.MIN_VALUE;
        }

        // 遇到左括号和+1,遇到右括号和-1。合法序列任意前缀的和>=0,且最终的和=0
        // dp[i][j]表示前缀长度为i,和为j的合法序列的最大价值
        // dp[i][j] = max{dp[i-1][j-1] + a[i], dp[i-1][j+1] + b[i]}, if j>0
        //            dp[i-1][j+1] + b[i], if j=0
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {

                if (j > 0) dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i], dp[i - 1][j + 1] + b[i]);
                else dp[i][j] = dp[i - 1][j + 1] + b[i];
            }
        }

        System.out.println(dp[n][0]);
    }
}
