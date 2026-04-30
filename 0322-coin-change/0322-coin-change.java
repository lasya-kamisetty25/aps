import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // DP array
        int[] dp = new int[amount + 1];

        // Initialize with large value
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // Base case

        // Build solution
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}