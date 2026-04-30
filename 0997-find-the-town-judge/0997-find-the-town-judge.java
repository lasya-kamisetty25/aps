class Solution {
    public int findJudge(int n, int[][] trust) {
        // Special case: if only one person and no trust relationships
        if (n == 1) {
            return 1;
        }

        // trustScore[i]:
        // +1 when someone trusts i
        // -1 when i trusts someone
        int[] trustScore = new int[n + 1];

        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];

            trustScore[a]--; // a trusts someone
            trustScore[b]++; // b is trusted
        }

        // Judge should have trustScore = n - 1
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}