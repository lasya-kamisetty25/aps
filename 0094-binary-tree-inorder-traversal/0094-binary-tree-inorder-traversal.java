import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // Go LEFT as much as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process node
            curr = stack.pop();
            result.add(curr.val);

            // Move RIGHT
            curr = curr.right;
        }

        return result;
    }
}