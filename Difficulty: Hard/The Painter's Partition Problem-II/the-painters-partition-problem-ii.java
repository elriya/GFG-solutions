class Solution {
    public int minTime(int[] arr, int k) {
        long low = 0;
        long high = 0;
        
        for (int length : arr) {
            low = Math.max(low, length); 
            high += length;            
        }
        
        long result = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                result = mid;   
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        
        return (int) result;
    }
    
    private boolean isPossible(int[] arr, int k, long maxTime) {
        int paintersUsed = 1;
        long currentTime = 0;
        
        for (int board : arr) {
            if (currentTime + board <= maxTime) {
                currentTime += board;
            } else {
                paintersUsed++;
                currentTime = board;
                
                if (paintersUsed > k) return false;
            }
        }
        
        return true;
    }
}