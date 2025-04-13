// https://leetcode.com/problems/rotting-oranges/

package DSA.Graph;

public class RottenOrange {
    int dfs(int i, int j, int[][] grid, int rottenCount) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = rottenCount;
        if (i < 0 || i > rows || j < 0 || j > cols || grid[i][j] != 1) {
            return -1;
        }
        if (grid[i - 1][j] == 2 && grid[i + 1][j] == 2 &&
                grid[i][j - 1] == 2 && grid[i][j + 1] == 2) {
            grid[i][j] = 2;
            count += 1;
            count += dfs(i - 1, j, grid, count);
            count += dfs(i + 1, j, grid, count);
            count += dfs(i, j - 1, grid, count);
            count += dfs(i, j + 1, grid, count);

        }
        return count;
    }

    public int orangesRotting(int[][] grid) {
        int rottenCount = dfs(1, 1, grid, -1);
        return rottenCount;
    }

    public static void main(String args[]) {
        RottenOrange o = new RottenOrange();
        int[][] grid = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        System.out.println(o.orangesRotting(grid));
    }
}