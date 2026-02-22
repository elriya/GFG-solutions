import java.util.HashMap;

class Solution {
    public long subarrayXor(int arr[], int k) {
        long count = 0;
        int currentXor = 0;
        HashMap<Integer, Integer> xorFreq = new HashMap<>();
        
        xorFreq.put(0, 1);
        
        for (int val : arr) {
            currentXor ^= val;
            
            int target = currentXor ^ k;
            
            if (xorFreq.containsKey(target)) {
                count += xorFreq.get(target);
            }
            
            xorFreq.put(currentXor, xorFreq.getOrDefault(currentXor, 0) + 1);
        }
        
        return count;
    }
}