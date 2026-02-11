class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int total = 0, left = 0;

        for (int x : nums) 
            total += x;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int right = total - left - nums[i];

            res[i] = nums[i] * i - left + right - nums[i] * (n - i - 1);

            left += nums[i];
        }

        return res;
    }
}
