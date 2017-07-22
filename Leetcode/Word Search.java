public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] mark = new boolean[m][n];

        // dfs的起始位置不确定，需要先找起始位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, mark, word, 0, i, j))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] mark, String word, int pos, int i, int j) {

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || mark[i][j] || word.charAt(pos) != board[i][j])
            return false;
        if (pos == word.length() - 1)
            return true;

        mark[i][j] = true;
        if (dfs(board, mark, word, pos+1, i+1, j) ||
            dfs(board, mark, word, pos+1, i, j+1) ||
            dfs(board, mark, word, pos+1, i-1, j) ||
            dfs(board, mark, word, pos+1, i, j-1))
                return true;
        mark[i][j] = false;  // 回溯

        return false;
    }
}
