import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.frequencySort("tree"));    // Output: "eert" or "eetr"
        System.out.println(sol.frequencySort("cccaaa"));  // Output: "cccaaa" or "aaaccc"
        System.out.println(sol.frequencySort("Aabb"));    // Output: "bbAa" or "bbaA"
    }
}
