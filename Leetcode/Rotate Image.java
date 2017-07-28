public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 沿副对角线反转
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }

        // 沿水平中线反转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
    }
}
