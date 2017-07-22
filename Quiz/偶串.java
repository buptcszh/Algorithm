// 如何找出一个字符串的所有子串，并判断其中偶串的个数，偶串指所有字符出现的次数为偶数次。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.next();

        int len = x.length();
        int count = 0;

        for (int i = 2; i <= len; i += 2) {
            for (int j = 0; j + i <= len; j++) {

                char[] chs = x.substring(j, j + i).toCharArray();

                // 子串中所有字符做xor运算。如果结果为0，说明其中的字符都出现偶数次
                int res = 0;
                for (char c : chs) {
                    res ^= c;
                }

                if (res == 0) count++;
            }
        }

        System.out.println(count);
    }
}
