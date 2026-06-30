import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        // Map each element of b to its index for O(1) lookups
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            mapB.put(b[i], i);
        }
        
        // Filter array 'a': keep only elements present in 'b' 
        // and replace them with their index position in 'b'
        List<Integer> filteredA = new ArrayList<>();
        for (int num : a) {
            if (mapB.containsKey(num)) {
                filteredA.add(mapB.get(num));
            }
        }
        
        // Find the Longest Increasing Subsequence (LIS) length of filteredA
        int lcsLength = findLIS(filteredA);
        
        // Total insertions and deletions
        return (n - lcsLength) + (m - lcsLength);
    }
    
    private int findLIS(List<Integer> list) {
        if (list.isEmpty()) return 0;
        
        List<Integer> tails = new ArrayList<>();
        for (int x : list) {
            int idx = Collections.binarySearch(tails, x);
            
            // If element is not found, binarySearch returns (-(insertion point) - 1)
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == tails.size()) {
                tails.add(x);
            } else {
                tails.set(idx, x);
            }
        }
        return tails.size();
    }
}