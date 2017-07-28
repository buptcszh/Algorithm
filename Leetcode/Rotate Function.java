public class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;

        int f = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;

        // 求递推公式，否则会超时
        for (int i = 1; i < n; i++) {
            f += sum - n * A[n - i];
            max = f > max ? f : max;
        }

        return max;
    }
}
