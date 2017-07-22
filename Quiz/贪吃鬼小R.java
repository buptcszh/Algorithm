// 小R每天吃巧克力的数量是前一天剩下的一半+3，要求最后一天剩下一块，求最开始需要有多少块
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(f(n));
        }
    }

    // f(n)表示倒数第n天剩下的巧克力个数，则f(1)=1
    // f(n)-f(n)/2-3 = f(n-1)
    private static long f(int n) {

        if (n == 1) return 1;
        return 2 * (f(n - 1) + 3);
    }
}
