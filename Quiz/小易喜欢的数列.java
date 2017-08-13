import java.util.*;

public class Main {
    private static final int MAX = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        // dp[i][j]表示长度为i的，以j结尾的合法数组的个数
        int[][] dp = new int[n+1][k+1];

        // 初始化，trick
        dp[0][1] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;  // sum表示以j结尾、长度为i时，所有可能的合法数组个数
            for (int x = 1; x <= k; x++) {
                sum += dp[i - 1][x];
                sum %= MAX;
            }

            for (int j = 1; j <= k; j++) {
                int illegal = 0;  // 例如AB，A不可以是B的倍数(A>B)
                for (int x = 2 * j; x <= k; x += j) {
                    illegal += dp[i - 1][x];
                    illegal %= MAX;
                }
                dp[i][j] = (sum - illegal + MAX) % MAX;
            }
        }

        int res = 0;
        for (int j = 1; j <= k; j++) {
            res += dp[n][j];
            res %= MAX;
        }
        System.out.println(res);
    }
}
