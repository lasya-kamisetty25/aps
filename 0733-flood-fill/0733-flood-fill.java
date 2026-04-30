class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // If starting pixel already has target color
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        // Boundary check
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        // Only fill matching original color
        if (image[row][col] != originalColor) {
            return;
        }

        // Change color
        image[row][col] = newColor;

        // Explore 4 directions
        dfs(image, row - 1, col, originalColor, newColor); // Up
        dfs(image, row + 1, col, originalColor, newColor); // Down
        dfs(image, row, col - 1, originalColor, newColor); // Left
        dfs(image, row, col + 1, originalColor, newColor); // Right
    }
}