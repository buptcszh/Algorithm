public class Solution {
    public boolean Find(int target, int[][] array) {

        int rows = array.length;
        int cols = array[0].length;

        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {

            if (array[row][col] == target) return true;
            else if (array[row][col] > target) col--;
            else row++;
        }

        return false;
    }
}
