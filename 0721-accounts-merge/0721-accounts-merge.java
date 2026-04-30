import java.util.*;

class Solution {
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        // Union-Find initialization
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map email -> account index
        Map<String, Integer> emailToAccount = new HashMap<>();

        // Step 1: Union accounts with common emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (emailToAccount.containsKey(email)) {
                    union(parent, i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        // Step 2: Group emails by root account
        Map<Integer, TreeSet<String>> mergedAccounts = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int root = find(parent, entry.getValue());

            mergedAccounts
                .computeIfAbsent(root, k -> new TreeSet<>())
                .add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry : mergedAccounts.entrySet()) {
            int accountIndex = entry.getKey();
            String name = accounts.get(accountIndex).get(0);

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(entry.getValue());

            result.add(merged);
        }

        return result;
    }

    // Find with path compression
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Union operation
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}