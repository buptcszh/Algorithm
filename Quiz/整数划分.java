// 如下所示：
// 1共0种划分方法
// 2共0种划分方法
// 3=2+1共1种划分方法
// 4=3+1=2+1+1共2种划分方法
// 5=4+1=3+2=3+1+1=2+2+1=2+1+1+1共5种划分方法
// 求n有几种划分方法

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {

            dp[0][i] = 1;
        }

        // dp[i][j]表示i的j划分,即划分出的最大值不超过j
        // dp[i][j] = dp[i-j][j] + dp[i][j-1], if j<=i
        //            dp[i][j-1]             , otherwise
        // 即将划分出的数分为包含j和不包含j两种情况讨论
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (j <= i) dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                else dp[i][j] = dp[i][j - 1];
            }
        }

        // 根据题意,去掉各项相等的情况(包括自己)
        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (n % i == 0) count++;  // 如果n能被i整除,则说明能划分出全部是i的情况
        }

        System.out.println(dp[n][n] - count);
    }
}
