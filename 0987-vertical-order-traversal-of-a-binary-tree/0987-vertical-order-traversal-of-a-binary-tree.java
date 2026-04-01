import java.util.*;

class Solution {

    class Pair {
        TreeNode node;
        int row, col;

        Pair(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col → row → minHeap(values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null)
                queue.offer(new Pair(node.left, row + 1, col - 1));

            if (node.right != null)
                queue.offer(new Pair(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            result.add(colList);
        }

        return result;
    }
}