public class Main {
    private static int ip2int(String ip) {
        String[] s = ip.split("\\.");
        int res = 0;
        for (int i = 3, j = 1; i >= 0; i--, j *= 256) {
            res += Integer.valueOf(s[i]) * j;
        }
        return res;
    }

    private static String int2ip(int num) {
        int[] x = new int[4];
        for (int i = 3; i >= 0; i--) {
            x[i] = num % 256;
            num /= 256;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(x[i]);
            if (i < 3) sb.append(".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "10.0.3.193";
        System.out.println(int2ip(ip2int(s)));
    }
}