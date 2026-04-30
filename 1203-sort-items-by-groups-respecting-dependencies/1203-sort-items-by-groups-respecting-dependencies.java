import java.util.*;

class Solution {
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step 1: Assign unique groups to ungrouped items
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Item graph
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        int[] itemIndegree = new int[n];

        // Group graph
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        int[] groupIndegree = new int[m];

        // Step 2: Build graphs
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                // Item dependency
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;

                // Group dependency
                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        // Step 3: Topological sort groups
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree, m);
        if (groupOrder.isEmpty()) {
            return new int[0];
        }

        // Step 4: Topological sort items
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree, n);
        if (itemOrder.isEmpty()) {
            return new int[0];
        }

        // Step 5: Group items according to group order
        Map<Integer, List<Integer>> groupedItems = new HashMap<>();
        for (int item : itemOrder) {
            groupedItems.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        List<Integer> result = new ArrayList<>();
        for (int grp : groupOrder) {
            if (groupedItems.containsKey(grp)) {
                result.addAll(groupedItems.get(grp));
            }
        }

        // Convert to array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // Generic Topological Sort using Kahn's Algorithm
    private List<Integer> topologicalSort(List<List<Integer>> graph, int[] indegree, int size) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return order.size() == size ? order : new ArrayList<>();
    }
}