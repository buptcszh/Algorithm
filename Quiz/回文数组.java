import java.util.Scanner;

public class Main {
    private static int[][] dp;
    private static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        dp = new int[n][n];

        int res = helper(0, n - 1);
        System.out.println(res);
    }

    private static int helper(int i, int j) {
        if (i > j) return 0;

        if (i == j) return num[i];

        if(dp[i][j] > 0) return dp[i][j];

        if (num[i] == num[j]) {
            dp[i][j] = helper(i + 1, j - 1) + num[i] + num[j];
        } else {
            dp[i][j] = Math.min(helper(i + 1, j) + 2 * num[i], helper(i, j - 1) + 2 * num[j]);
        }

        return dp[i][j];
    }
}