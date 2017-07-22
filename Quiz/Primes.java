public class Primes {
    private static boolean[] getPrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 如果i*i>n, 就没有必要继续了
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;

            // 从i*i开始, 因为k*i (k<i)的肯定已经被筛过了
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        int n = 1000;

        boolean[] isPrime = getPrimes(n);
        for (int i = 1; i <= n; i++) {
            if (isPrime[i])
                System.out.print(i + " ");
        }
    }
}
