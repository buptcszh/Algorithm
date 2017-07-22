// 小明得到了n个石头，他想把这些石头分成若干堆，每堆至少有一个石头。他把这些石堆排在一条直线上，他希望任意相邻两堆的石头数都不一样。
// 小明最后的得分为石头数大于等于k的石堆数，问他最多能得多少分。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 分出来的堆一定形如{k, k+1, k, k+1, ...}
        int x = n / (2 * k + 1);
        int y = n % (2 * k + 1);

        if (y >= k) System.out.println(2 * x + 1);
        else System.out.println(2 * x);
    }
}
