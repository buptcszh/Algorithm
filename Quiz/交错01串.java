import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int max = 1, temp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }

        System.out.println(max);
    }
}
