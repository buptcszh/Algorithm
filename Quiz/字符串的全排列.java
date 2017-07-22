public class Main {

    private static void permutation(char[] chs, int start, int end) {

        if (start == end) {

            System.out.println(chs);
            return;
        }


        for (int i = start; i <= end; i++) {

            swap(chs, start, i);  // 把i放前面
            permutation(chs, start + 1, end);  // 求start+1开始的全排列
            swap(chs, start, i);
        }
    }

    private static void swap(char[] chs, int i, int j) {

        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {

        String s = "abc";
        permutation(s.toCharArray(), 0, s.length() - 1);
    }
}
