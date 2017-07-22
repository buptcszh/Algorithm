public class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {

                    disappear(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void disappear(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length)    return;
        if (j < 0 || j >= grid[i].length) return;
        if (grid[i][j] == '0')            return;

        grid[i][j] = '0';

        disappear(grid, i+1, j);
        disappear(grid, i-1, j);
        disappear(grid, i, j+1);
        disappear(grid, i, j-1);
    }
}
