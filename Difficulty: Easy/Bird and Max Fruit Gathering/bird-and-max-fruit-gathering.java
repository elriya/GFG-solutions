import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        
        // Use long to prevent overflow (max possible sum is 10^12)
        long currentSum = 0;
        
        for (int i = 0; i < m; i++) {
            currentSum += arr.get(i);
        }
        
        long maxSum = currentSum;
        
        for (int i = 1; i < n; i++) {
            currentSum -= arr.get(i - 1);
            
            // Handle circular array wrap-around efficiently
            int addIndex = i + m - 1;
            if (addIndex >= n) {
                addIndex -= n;
            }
            
            currentSum += arr.get(addIndex);
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return (int) maxSum;
    }
}