class Solution {
    public String longestNiceSubstring(String s) {
        return divideAndConquer(s);
    }

    private String divideAndConquer(String s) {
        // Base case
        if (s.length() < 2) {
            return "";
        }

        // Store characters
        java.util.Set<Character> set = new java.util.HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Find invalid character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If counterpart missing
            if (set.contains(Character.toLowerCase(c)) &&
                set.contains(Character.toUpperCase(c))) {
                continue;
            }

            // Split and recurse
            String left = divideAndConquer(s.substring(0, i));
            String right = divideAndConquer(s.substring(i + 1));

            // Return longer one
            return left.length() >= right.length() ? left : right;
        }

        // Entire string is nice
        return s;
    }
}