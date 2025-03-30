package Problems.Graph;

public class NumIslands {
    void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != '1') {
            return;
        } else {
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslandsCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslandsCount += 1;
                    dfs(i, j, grid);
                }
            }
        }
        return numIslandsCount;
    }

    public static void main(String[] args) {
        NumIslands islands = new NumIslands();
        /*
         * char[][] arr = {
         * { '1', '1', '1', '1', '0' },
         * { '1', '1', '0', '1', '0' },
         * { '1', '1', '0', '0', '0' },
         * { '0', '0', '0', '0', '0' }
         * };
         */
        char[][] arr = { { '1', '1' } };
        System.out.println(islands.numIslands(arr));
    }
}
