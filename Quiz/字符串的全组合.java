public class Main {

    private static void combination(char[] chs) {

        int len = chs.length;

        int n = 1 << len;  // 使用位图001~111，1表示选择了对应位置的字符
        for (int i = 1; i < n; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {

                if ((i & (1 << j)) != 0) sb.append(chs[j]);
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {

        String s = "abc";
        combination(s.toCharArray());
    }
}
