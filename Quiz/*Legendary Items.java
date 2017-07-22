// Little Hi is playing a video game. Each time he accomplishes a quest in the game, Little Hi has a chance to get a legendary item.
// At the beginning the probability is P%. Each time Little Hi accomplishes a quest without getting a legendary item, the probability will go up Q%. Since the probability is getting higher he will get a legendary item eventually.
// After getting a legendary item the probability will be reset to ⌊P/(2I)⌋% (⌊x⌋ represents the largest integer no more than x) where I is the number of legendary items he already has. The probability will also go up Q% each time Little Hi accomplishes a quest until he gets another legendary item.
// Now Little Hi wants to know the expected number of quests he has to accomplish to get N legendary items.
// Assume P = 50, Q = 75 and N = 2, as the below figure shows the expected number of quests is
// 2*50%*25% + 3*50%*75%*100% + 3*50%*100%*25% + 4*50%*100%*75%*100% = 3.25

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int N = sc.nextInt();
        double ret = 0.0;
        double dq = 1.0 * Q / 100;
        double[] val = new double[1005];
        for (int i = 0; i <= 100; i++) {
            val[i] = -1000;
        }
        for (int i = 0; i < N; i++) {
            if (val[P] == -1000) {
                val[P] = Main.calc(P, dq);
            }
            ret += val[P];
            P /= 2;
        }
        System.out.printf("%.2f\n", ret);
    }

    public static double calc(int p, double q) {
        double pp = 0.01 * p;
        double rtn = 1;
        double bef = 1;
        int j = 1;
        while (j <= 100) {
            bef *= (1 - pp);
            rtn += bef;
            pp += q;
            if (pp >= 1.0) {
                break;
            }
            j++;
        }

        return rtn;
    }

}
