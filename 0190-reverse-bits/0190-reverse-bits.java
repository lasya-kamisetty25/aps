public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Shift result left to make space
            result <<= 1;

            // Add last bit of n
            result |= (n & 1);

            // Shift n right
            n >>>= 1; // Unsigned shift
        }

        return result;
    }
}