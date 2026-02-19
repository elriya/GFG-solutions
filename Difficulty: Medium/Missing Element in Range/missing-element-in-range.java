import java.util.*;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>();
        
        boolean[] present = new boolean[100001];
        
        for (int num : arr) {
            if (num <= 100000) {
                present[num] = true;
            }
        }
        
        for (int i = low; i <= high; i++) {
            if (i > 100000 || !present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}