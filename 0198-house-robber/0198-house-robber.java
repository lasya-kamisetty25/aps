class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Base cases
        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        // DP iteration
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}