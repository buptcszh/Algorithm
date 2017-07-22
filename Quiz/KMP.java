public class KMP {

    // 基于dfa实现的kmp算法，空间复杂度高，但容易理解
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {

        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];  // 表示在状态M遇到输入字符R时的转移状态

        // 构建dfa
        dfa[pat.charAt(0)][0] = 1;            // 初始化状态0
        for (int X = 0, j = 1; j < M; j++) {  // X维护重启位置
            // 匹配失败
            // 相当于把pat[1...j-1]放入dfa得到状态X (但X是迭代过程中维护着的), 再从X匹配pat[j]
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            // 匹配成功
            // 更新状态和重启位置X
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;  // 匹配成功
        else return -1;            // 匹配失败
    }

    public static void main(String[] args) {
        String pat = "ABC";
        String txt = "ABCABC";

        KMP kmp = new KMP(pat);
        int offset = kmp.search(txt);
        System.out.print(offset);
    }
}
