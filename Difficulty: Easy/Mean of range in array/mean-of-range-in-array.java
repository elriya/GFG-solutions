import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        
        long[] prefixSum = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            
            long sum = prefixSum[r + 1] - prefixSum[l];
            
            int count = r - l + 1;
            
            result.add((int) (sum / count));
        }
        
        return result;
    }
}