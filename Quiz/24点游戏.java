import java.util.Scanner;

public class Main {

    private static final double PRECISION = 1E-6;
    private static double num[] = new double[4];
    private static boolean flag;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            can24(a, b, c, d);
        }
    }

    public static void game24(int n) {

        if (n == 1 && Math.abs(num[0] - 24) <= PRECISION) {

            flag = true;
            return;
        }

        // dfs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double a = num[i];
                double b = num[j];
                num[j] = num[n - 1];

                num[i] = a + b;
                game24(n - 1);

                num[i] = a - b;
                game24(n - 1);

                num[i] = b - a;
                game24(n - 1);

                num[i] = a * b;
                game24(n - 1);

                if (b != 0) {
                    num[i] = a / b;
                    game24(n - 1);
                }

                if (a != 0) {
                    num[i] = b / a;
                    game24(n - 1);
                }

                // 回溯
                num[i] = a;
                num[j] = b;
            }
        }
    }

    public static void can24(int a, int b, int c, int d) {

        num[0] = (double) a;
        num[1] = (double) b;
        num[2] = (double) c;
        num[3] = (double) d;

        flag = false;

        game24(4);

        if (flag) System.out.println("yes");
        else System.out.println("no");
    }
}
