import java.util.HashSet;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> seen = new HashSet<>();
        
        for (int num : arr) {
            long current = (long) num;
            
            if (target == 0) {
                if (current == 0 && !seen.isEmpty()) {
                    return true;
                }
                if (current != 0 && seen.contains(0L)) {
                    return true;
                }
            } 
            else {
                if (current != 0 && target % current == 0) {
                    long required = target / current;
                    if (seen.contains(required)) {
                        return true;
                    }
                }
            }
            
            seen.add(current);
        }
        
        return false;
    }
}