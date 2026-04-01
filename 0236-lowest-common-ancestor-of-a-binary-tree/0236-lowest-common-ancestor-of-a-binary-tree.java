class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides found → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return non-null side
        return (left != null) ? left : right;
    }
}