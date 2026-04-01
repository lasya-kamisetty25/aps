import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        
        if (node == null) return;

        // build path
        if (path.length() == 0)
            path = "" + node.val;
        else
            path = path + "->" + node.val;

        // if leaf → store
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // go deeper
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}