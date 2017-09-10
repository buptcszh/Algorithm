// 如下所示：
// 1共0种划分方法
// 2共0种划分方法
// 3=2+1共1种划分方法
// 4=3+1=2+1+1共2种划分方法
// 5=4+1=3+2=3+1+1=2+2+1=2+1+1+1共5种划分方法
// 求n有几种划分方法

import java.util.*;

// 动态规划法
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {

            dp[0][i] = 1;
        }

        // dp[i][j]表示i的j划分,即划分出的最大值不超过j
        // dp[i][j] = dp[i-j][j] + dp[i][j-1], if j<=i
        //            dp[i][j-1]             , otherwise
        // 即将划分出的数分为包含j和不包含j两种情况讨论
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (j <= i) dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                else dp[i][j] = dp[i][j - 1];
            }
        }

        // 根据题意,去掉各项相等的情况(包括自己)
        int count = 0;
        for (int i = 1; i <= n; i++) {

            if (n % i == 0) count++;  // 如果n能被i整除,则说明能划分出全部是i的情况
        }

        System.out.println(dp[n][n] - count);
    }
}

// 母函数法
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] c1 = new int[n + 1];  // 保存最终结果的系数
        int[] c2 = new int[n + 1];  // 保存临时结果的系数

        c1[0] = 1;  // 一开始最终结果为1，即1*x^0+0*x^1+...+0*x^n

        for (int i = 1; i <= n; i++) {              // 与第i个括号相乘
            for (int j = 0; j <= n; j += i) {       // 第i个括号里的幂次j，整数i的步长为i
                for (int k = 0; k + j <= n; k++) {  // 遍历最终结果中的所有幂次k，相乘以后的幂次为k+j，保存在临时结果中
                    c2[k + j] += c1[k];             // 累加的是k次幂的系数，因为j次幂的系数是1
                }
            }

            // 交换，并将临时结果清空
            for (int k = 0; k <= n; k++) {
                c1[k] = c2[k];
                c2[k] = 0;
            }
        }

        System.out.println(c1[n]);
    }
}

// 母函数法还可以解决：

// 求用1分、2分、3分的邮票贴出不同数值的方案数（每张邮票的数量是无限的）
// 那么
// 1分：(1+x^1+x^2+x^3+x^4+......)，即0张1分、1张1分、2张1分...
// 2分：(1+x^2+x^4+x^6+x^8+......)，即0张2分、1张2分、2张2分...
// 3分：(1+x^3+x^6+x^9+x^12+......)，即0张3分、1张3分、3张3分...
// 然后这3个乘起来，x^n的系数即贴出n分的方案数