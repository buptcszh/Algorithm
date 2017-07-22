// 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。
// 考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。
// 你能帮他算出他通过考试的概率吗？

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] nums = new double[n];

        for (int i = 0; i < n; i++) {
            nums[i] = (double) sc.nextInt() / 100;
        }

        int m = (int) Math.ceil(n * 0.6d);

        // dp[i][j]表示前i道题做对j道的概率
        // dp[i][j] = dp[i-1][j-1]*nums[i] + dp[i-1][j]*(1-nums[i]), j>0  即第i道做对+第i道没做对两种情况
        //          = dp[i-1][0]*(1-nums[i]), j=0
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (j == 0)
                    dp[i][j] = dp[i - 1][0] * (1 - nums[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j - 1] * nums[i - 1] + dp[i - 1][j] * (1 - nums[i - 1]);
            }
        }

        double res = 0;
        for (int i = m; i <= n; i++) {

            res += dp[n][i];
        }

        System.out.println(String.format("%.5f", res));
    }
}
