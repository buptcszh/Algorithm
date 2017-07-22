// 找到先升后降的最宽区间的起始和结束位置

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {

            nums[i] = in.nextInt();
        }

        int[] left = new int[n];  // left[i]表示i左边有几个连续上升的点
        int[] right = new int[n];  // right[i]表示i右边有几个连续下降的点

        for (int i = 1; i < n; i++) {

            if (nums[i] > nums[i - 1]) left[i] = left[i - 1] + 1;
            else left[i] = 0;
        }

        for (int i = n - 2; i > 0; i--) {

            if (nums[i] > nums[i + 1]) right[i] = right[i + 1] + 1;
            else right[i] = 0;
        }

        int sum = 0, pos = -1;
        for (int i = 0; i < n; i++) {

            // 都不为零时才计算max
            if (left[i] > 0 && right[i] > 0) {

                if (left[i] + right[i] > sum) {

                    sum = left[i] + right[i];
                    pos = i;
                }
            }
        }

        if (pos == -1) System.out.println("-1 -1");
        else System.out.println((pos - left[pos]) + " " + (pos + right[pos]));
    }
}
