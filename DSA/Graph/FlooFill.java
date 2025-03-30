/*https://leetcode.com/problems/flood-fill/description/ */
package DSA.Graph;

public class FlooFill {
    void dfs(int i, int j, int[][] image, int color, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || image[i][j] != color) {
            return;
        } else {
            image[i][j] = newColor;
            dfs(i - 1, j, image, color, newColor);
            dfs(i + 1, j, image, color, newColor);
            dfs(i, j - 1, image, color, newColor);
            dfs(i, j + 1, image, color, newColor);
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        dfs(sr, sc, image, image[sr][sc], color);
        return image;
    }

    public static void main(String[] args) {
        FlooFill fill = new FlooFill();
        int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] image = fill.floodFill(arr, 1, 1, 2);
        for (var k : image) {
            System.out.println();
            for (var l : k) {
                System.out.print(" " + l);
            }
        }
    }
}
