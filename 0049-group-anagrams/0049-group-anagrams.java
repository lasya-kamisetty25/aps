import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map sorted word -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert word to char array and sort it
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            // Sorted string as key
            String key = new String(chars);

            // Add word to corresponding group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Return grouped anagrams
        return new ArrayList<>(map.values());
    }
}