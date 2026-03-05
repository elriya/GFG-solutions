import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int maxLen = -1;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char rightChar = s.charAt(j);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }

            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}