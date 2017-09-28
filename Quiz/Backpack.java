public class Backpack {
    // N个物品放入重量为V的背包
    private static int[] w = new int[]{1,2,3,4,5};  // 价值
    private static int[] c = new int[]{5,4,3,2,1};  // 重量
    private static int[] m = new int[]{1,2,3,4,5};  // 数量

    public static void main(String[] args) {
        int res = backpack3(5, 10);
        System.out.println(res);
    }

    // 0-1背包（优化空间复杂度）
    // dp[i][v] = max{dp[i-1][v], dp[i-1][v-c(i)] + w(i)}
    public static int backpack1(int N, int V) {
        // dp[j]表示第i次循环结束后，将前j件物品放入背包中的最大价值
        int[] dp = new int[V+1];

        for (int i = 0; i < N; i++) {
            // 【逆序】才能保证在计算dp[v]时，dp[v-c[i]]中存放的是上一次循环后的值
            for (int v = V; v >= c[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v-c[i]] + w[i]);
            }
        }

        return dp[V];
    }

    // 完全背包（优化空间复杂度）
    public static int backpack2(int N, int V) {
        // dp[j]表示第i次循环结束后，将前j件物品放入背包中的最大价值
        int[] dp = new int[V+1];
        
        for (int i = 0; i < N; i++) {
            // 【顺序】表明在计算dp[v]时，考虑了已放入一些第i个物品的情况(本次循环中的结果)
            for (int v = c[i]; v <= V; v++) {
                dp[v] = Math.max(dp[v], dp[v-c[i]] + w[i]);
            }
        }

        return dp[V];
    }

    // 多重背包m
    // dp[i][v] = max{dp[i-1][v - k * c[i-1]] + k * w[i-1]}, 0<=k<=m[i-1]
    public static int backpack3(int N, int V) {
        int[][] dp = new int[N+1][V+1];

        for (int i = 1; i <= N; i++) {
            for (int v = 1; v <= V; v++) {
                for (int k = 0; k <= m[i-1]; k++) {
                    if (v - k * c[i-1] >= 0) {
                        dp[i][v] = Math.max(dp[i][v], dp[i-1][v - k * c[i-1]] + k * w[i-1]);                        
                    }
                    else break;
                }
            }
        }

        return dp[N][V];
    }
}