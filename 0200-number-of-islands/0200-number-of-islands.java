class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Traverse every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // If land found, start DFS
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check or water check
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        // Mark visited land as water
        grid[row][col] = '0';

        // Explore all 4 directions
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}