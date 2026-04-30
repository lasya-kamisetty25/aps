import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[rows][cols];

        // Initialize distances
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Multi-source BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check boundaries
                if (newX >= 0 && newX < rows &&
                    newY >= 0 && newY < cols) {

                    // If shorter distance found
                    if (distance[newX][newY] > distance[x][y] + 1) {
                        distance[newX][newY] = distance[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return distance;
    }
}