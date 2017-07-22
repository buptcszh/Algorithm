// 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
// n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] len = new int[n+1];
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            int x = in.nextInt();
            len[i] = x / 1024;
            sum += len[i];
        }

        // 背包容量为数据总长度的一半
        int v = (int) Math.ceil(sum / 2.0);

        int[][] f = new int[n+1][v+1];

        // f[i][j] = max{f[i-1][j], f[i-1][j-v(i)] + w(i)}
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {

                if (j < len[i])
                    f[i][j] = f[i-1][j];
                else
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-len[i]] + len[i]);  // 价值就等于数据长度
            }
        }

        int res = Math.max(sum - f[n][v], f[n][v])*1024;  // 处理时间为两个背包总价值的最大值
        System.out.println(res);
    }
}
