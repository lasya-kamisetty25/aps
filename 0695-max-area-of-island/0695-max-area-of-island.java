class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;

        // Traverse every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS if land is found
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check or water check
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited
        grid[row][col] = 0;

        // Count current cell + connected neighbors
        return 1
                + dfs(grid, row - 1, col) // Up
                + dfs(grid, row + 1, col) // Down
                + dfs(grid, row, col - 1) // Left
                + dfs(grid, row, col + 1); // Right
    }
}