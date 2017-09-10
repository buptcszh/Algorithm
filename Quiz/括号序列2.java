// 已知一个合法的括号序列，一次合法的移除操作指的是删除第一个"("，再删除一个")"后仍然是一个合法的括号序列，求将括号序列变为空的合法移除操作的种数
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int res = 1, count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else {
                res *= count;
                count--;
            }
        }

        System.out.println(res);
    }
}