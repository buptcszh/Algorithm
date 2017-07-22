// O(n)的时间复杂度求一个字符串的逆序数，如DBBAC=6

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] x = sc.nextLine().toCharArray();

        // 统计每个字符出现的次数
        int[] count = new int[4];

        int res = 0;
        for (int i = 0; i < x.length; i++) {

            int temp = x[i] - 'A';
            count[temp]++;

            for (int j = temp + 1; j < 4; j++) {

                res += count[j];
            }
        }
        System.out.println(res);
    }
}
