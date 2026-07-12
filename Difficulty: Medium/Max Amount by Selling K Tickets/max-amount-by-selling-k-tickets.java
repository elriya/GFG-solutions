import java.util.Arrays;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long MOD = 1_000_000_007L;
        
        int maxVal = 0;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
        }
        
        int low = 1, high = maxVal;
        int threshold = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countTickets(arr, mid) >= k) {
                threshold = mid; 
                low = mid + 1;   
            } else {
                high = mid - 1;  
            }
        }
        
        long totalEarnings = 0;
        long ticketsSold = 0;
        
        // Sell all tickets strictly greater than 'threshold'
        for (int num : arr) {
            if (num > threshold) {
                long count = num - threshold;
                ticketsSold += count;
                
                long sum = (count * (threshold + 1 + num)) / 2;
                totalEarnings = (totalEarnings + sum) % MOD;
            }
        }
        
        // The remaining tickets needed to reach exactly k are sold at exactly 'threshold'
        if (ticketsSold < k) {
            long remainder = k - ticketsSold;
            totalEarnings = (totalEarnings + (remainder * threshold) % MOD) % MOD;
        }
        
        return (int) totalEarnings;
    }
    
    // Helper function to count tickets available at a price >= priceThreshold
    private long countTickets(int[] arr, int priceThreshold) {
        long count = 0;
        for (int num : arr) {
            if (num >= priceThreshold) {
                count += (num - priceThreshold + 1);
            }
        }
        return count;
    }
}