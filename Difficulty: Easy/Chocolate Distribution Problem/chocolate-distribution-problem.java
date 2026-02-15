import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        if (m == 0 || arr.size() == 0) {
            return 0;
        }

        Collections.sort(arr);

        int n = arr.size();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + m - 1 < n; i++) {
            int currentDiff = arr.get(i + m - 1) - arr.get(i);
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}