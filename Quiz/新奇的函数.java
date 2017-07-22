// f(x)为x！末尾0的个数
// g(x)=v，v是满足f(v)=x的最小值
// hint：g(x)是非递减函数
// 求g(x)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        System.out.println(g(x));
    }

    private static int f(int x) {

        int count = 0;

        while (x > 0) {

            count += x / 5;
            x /= 5;
        }

        return count;
    }

    private static int g(int x) {

        int res = -1;
        int left = 1, right = 1 << 9;  // 离散的取值，单调 -> 二分法

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (f(mid) == x) {

                res = mid;
                right = mid - 1;  // 找到最左边的值
            }
            else if (f(mid) > x) right = mid - 1;
            else left = mid + 1;
        }

        return res;
    }
}
