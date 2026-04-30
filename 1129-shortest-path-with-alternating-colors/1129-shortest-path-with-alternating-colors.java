import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        // Graph representation:
        // graph[node][0] = red neighbors
        // graph[node][1] = blue neighbors
        List<Integer>[][] graph = new ArrayList[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = new ArrayList<>();
            graph[i][1] = new ArrayList<>();
        }

        // Add red edges
        for (int[] edge : redEdges) {
            graph[edge[0]][0].add(edge[1]);
        }

        // Add blue edges
        for (int[] edge : blueEdges) {
            graph[edge[0]][1].add(edge[1]);
        }

        // Result array
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        // visited[node][color]
        boolean[][] visited = new boolean[n][2];

        // Queue: {node, distance, previousColor}
        // previousColor: 0 = red, 1 = blue
        Queue<int[]> queue = new LinkedList<>();

        // Start from node 0 with both colors
        queue.offer(new int[]{0, 0, -1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];
            int prevColor = current[2];

            // Set shortest distance
            if (answer[node] == -1) {
                answer[node] = dist;
            }

            // Try red edge next
            if (prevColor != 0) {
                for (int neighbor : graph[node][0]) {
                    if (!visited[neighbor][0]) {
                        visited[neighbor][0] = true;
                        queue.offer(new int[]{neighbor, dist + 1, 0});
                    }
                }
            }

            // Try blue edge next
            if (prevColor != 1) {
                for (int neighbor : graph[node][1]) {
                    if (!visited[neighbor][1]) {
                        visited[neighbor][1] = true;
                        queue.offer(new int[]{neighbor, dist + 1, 1});
                    }
                }
            }
        }

        return answer;
    }
}