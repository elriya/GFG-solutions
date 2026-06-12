import java.util.*;

class Solution {
    public boolean kSubstr(String s, int k) {
        int n = s.length();
        
        if (n % k != 0) {
            return false;
        }
        
        Map<String, Integer> blockCounts = new HashMap<>();
        
        for (int i = 0; i < n; i += k) {
            String block = s.substring(i, i + k);
            blockCounts.put(block, blockCounts.getOrDefault(block, 0) + 1);
        }
        
        if (blockCounts.size() == 1) {
            return true;
        }
        
        if (blockCounts.size() == 2) {
            for (int count : blockCounts.values()) {
                if (count == 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}