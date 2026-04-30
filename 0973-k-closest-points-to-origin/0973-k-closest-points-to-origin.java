import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        // Max Heap based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        for (int[] point : points) {
            maxHeap.offer(point);

            // Keep only k closest points
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare result
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    // Calculate squared distance
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}