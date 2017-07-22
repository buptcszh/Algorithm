public class LCS {
    // 最长公共子序列 (不要求连续)
    public static int longestCommonSubsequence(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

        int[][] f = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            f[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < l2; i++) {
            f[0][i] = a.charAt(0) == b.charAt(i) ? 1 : 0;
        }

				// f[i][j] = f[i-1][j-1] + 1           , if a[i]=b[j]
				//         = max{f[i][j-1], f[i-1][j]} , otherwise
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

    // 最长公共子串 (要求连续)
    public static int longestCommonSubstring(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

        int[][] f = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            f[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
        }
        for (int i = 0; i < l2; i++) {
            f[0][i] = a.charAt(0) == b.charAt(i) ? 1 : 0;
        }

				// f[i][j] = f[i-1][j-1] + 1 , if a[i]=b[j]
			  //         = 0               , otherwise
        int max = 0;
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {

                if (a.charAt(i) == b.charAt(j)) {

                    f[i][j] = f[i - 1][j - 1] + 1;
                    max = f[i][j] > max ? f[i][j] : max;
                }
                else
                    f[i][j] = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("baaaab", "cabaaxaa"));
    }
}
