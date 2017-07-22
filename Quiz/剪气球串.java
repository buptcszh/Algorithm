// 一个长度为n的数组，每个数的范围是1-9，现在我们需要将这个数组分成多个连续的子数组，保证每个子数组内数组均不相同，问一共有多少种分法

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] count = new int[10];
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int c = 1, j = i; c <= 9 && j > 0; c++, j--) {
                count[nums[j]]++;
                if (count[nums[j]] > 1) break;
                else dp[i] += dp[j - 1];
            }
            Arrays.fill(count, 0);
        }

        System.out.println(dp[n]);
    }
}
