import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Start from room 0
        queue.offer(0);
        visited[0] = true;
        int visitedCount = 1;

        // BFS traversal
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();

            // Collect all keys in current room
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                    visitedCount++;
                }
            }
        }

        // Check if all rooms were visited
        return visitedCount == n;
    }
}