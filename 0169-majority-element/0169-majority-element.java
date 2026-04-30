class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // Choose new candidate
            if (count == 0) {
                candidate = num;
            }

            // Update count
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}