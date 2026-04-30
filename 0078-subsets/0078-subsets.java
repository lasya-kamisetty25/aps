import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset
        result.add(new ArrayList<>(current));

        // Explore further elements
        for (int i = start; i < nums.length; i++) {
            // Choose
            current.add(nums[i]);

            // Recurse
            backtrack(nums, i + 1, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}