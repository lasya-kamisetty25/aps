import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // In-degree array
        int[] inDegree = new int[numCourses];

        // Build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;

        // Topological Sort (Kahn’s Algorithm)
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all courses completed, return true
        return completedCourses == numCourses;
    }
}