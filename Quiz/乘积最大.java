import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (j <= i) dp[i][j] = Math.max(dp[i - j][j - 1] * j, dp[i][j - 1]);
                else dp[i][j] = dp[i][j - 1];
            }
        }

        System.out.println(dp[n][n]);
    }
}
