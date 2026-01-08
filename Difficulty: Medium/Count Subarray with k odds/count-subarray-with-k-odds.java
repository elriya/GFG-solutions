import java.util.HashMap;

class Solution {
    public int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        int currentOdds = 0;
        int result = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) {
                currentOdds++;
            }
            
            if (map.containsKey(currentOdds - k)) {
                result += map.get(currentOdds - k);
            }
            
            map.put(currentOdds, map.getOrDefault(currentOdds, 0) + 1);
        }
        
        return result;
    }
}