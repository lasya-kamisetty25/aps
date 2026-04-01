import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // Add at beginning (reverse effect)
            result.addFirst(node.val);

            // Push LEFT first
            if (node.left != null)
                stack.push(node.left);

            // Push RIGHT next
            if (node.right != null)
                stack.push(node.right);
        }

        return result;
    }
}