public class Palindrome {
    public static int makePalindrome(String s) {
        // 反转字符串，求原串与反转串的LCS
        // len(s)-len(LCS)即需要补的最少字符数
        String c = new StringBuffer(s).reverse().toString();
        return s.length() - longestCommonSubsequence(s, c);
    }

    // 最长公共子序列 (不要求连续)
    private static int longestCommonSubsequence(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

        int[][] f = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            f[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < l2; i++) {
            f[0][i] = a.charAt(0) == b.charAt(i) ? 1 : 0;
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {

                if (a.charAt(i) == b.charAt(j))
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }

        return f[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        System.out.println(makePalindrome("asdfd"));
    }
}
