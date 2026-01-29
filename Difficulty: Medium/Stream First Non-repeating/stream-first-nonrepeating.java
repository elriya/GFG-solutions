import java.util.*;

class Solution {
    public String firstNonRepeating(String s) {
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            freq[curr - 'a']++;
            queue.add(curr);

            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}