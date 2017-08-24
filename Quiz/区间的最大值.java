// 给定一个数组序列，要求选出一个区间，使得该区间是经过如下计算的值最大的一个：区间中的最小数 * 区间中的所有数之和
// 输出最大值即可，不要求输出具体的区间

// 解法：找到最小值，将区间划分成左右两部分，递归求解
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(recursion(nums, 0, n - 1));
    }

    private static int recursion(int[] nums, int begin, int end) {
        if (begin > end) return 0;

        int minPos = begin, sum = 0;
        for (int i = begin; i <= end; i++) {
            if (nums[i] < nums[minPos]) minPos = i;
            sum += nums[i];
        }
        int temp = sum * nums[minPos];

        // 这个区间是包含这个最小值的最优区间了，其它可能成为最优解的区间不可能再包含这个最小值
        int left = recursion(nums, begin, minPos - 1);
        int right = recursion(nums, minPos + 1, end);

        // 求这三部分的最大值
        return Math.max(temp, Math.max(left, right));
    }
}
