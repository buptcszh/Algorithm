import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }

        // res[c]表示棋盘上至少有一个格子有c个棋子时，所需要的操作数
        int[] res = new int[n + 1];
        for (int c = 1; c <= n; c++) {
            res[c] = Integer.MAX_VALUE;
        }

        for (int c = 1; c <= n; c++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 以(x[i],y[j])为中心，计算各个棋子距离该点的曼哈顿距离
                    int[] manhattan = new int[n];
                    for (int k = 0; k < n; k++) {
                        manhattan[k] = Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]);
                    }

                    // 选前c小的距离求和
                    Arrays.sort(manhattan);
                    int sum = 0;
                    for (int k = 0; k < c; k++) {
                        sum += manhattan[k];
                    }
                    // 保存最小的距离之和
                    res[c] = Math.min(res[c], sum);
                }
            }
        }

        for (int c = 1; c <= n; c++) {
            System.out.print(res[c]);
            if (c < n) System.out.print(" ");
        }
        System.out.println();
    }
}
