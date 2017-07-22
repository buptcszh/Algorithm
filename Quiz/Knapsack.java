public class Knapsack {
    public static int maxValue(int cap, int[] weight, int[] value) {

        int n = weight.length;
        int[][] f = new int[n + 1][cap + 1];

        // f[i][j]表示将前i件物品放入容量为j的背包中,可以获得的最大价值
        // f[i][j] = max{f[i-1][j], f[i-1][j-w(i)] + v(i)}
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {

                if (weight[i - 1] <= j)
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - weight[i - 1]] + value[i - 1]);
                else
                    f[i][j] = f[i - 1][j];
            }
        }

        return f[n][cap];
    }
}
