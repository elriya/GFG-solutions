import java.util.ArrayList;

class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // leftPeak[i] stores the leftmost index reachable from i moving left while elements increase or stay equal
        int[] leftPeak = new int[n];
        leftPeak[0] = 0;
        for (int i = 1; i < n; i++) {
            leftPeak[i] = (arr[i - 1] >= arr[i]) ? leftPeak[i - 1] : i;
        }
        
        // rightPeak[i] stores the rightmost index reachable from i moving right while elements increase or stay equal
        int[] rightPeak = new int[n];
        rightPeak[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            rightPeak[i] = (arr[i] <= arr[i + 1]) ? rightPeak[i + 1] : i;
        }
        
        ArrayList<Boolean> result = new ArrayList<>();
        
        // Subarray [l, r] is a mountain if the increasing range from l meets/crosses the increasing range from r
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            result.add(rightPeak[l] >= leftPeak[r]);
        }
        
        return result;
    }
}