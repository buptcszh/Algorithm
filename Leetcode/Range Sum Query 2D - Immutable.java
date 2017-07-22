public class Solution {
    private int[][] s;

    public NumMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (i == 0 && j != 0) matrix[i][j] += matrix[i][j-1];
                if (i != 0 && j == 0) matrix[i][j] += matrix[i-1][j];
                if (i != 0 && j != 0) matrix[i][j] += matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
            }
        }
        s = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (row1 == 0 && col1 == 0) return s[row2][col2];
        if (row1 == 0 && col1 != 0) return s[row2][col2] - s[row2][col1-1];
        if (row1 != 0 && col1 == 0) return s[row2][col2] - s[row1-1][col2];
        return s[row2][col2] - s[row1-1][col2] - s[row2][col1-1] + s[row1-1][col1-1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
