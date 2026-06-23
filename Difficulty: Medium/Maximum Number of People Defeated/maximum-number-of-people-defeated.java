class Solution {
    public int maxPeopleDefeated(int p) {
        long low = 0;
        long high = 1000;
        int ans = 0;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            long requiredStrength = mid * (mid + 1) * (2 * mid + 1) / 6;
            
            if (requiredStrength <= p) {
                ans = (int) mid;     
                low = mid + 1;      
            } else {
                high = mid - 1;      
            }
        }
        
        return ans;
    }
}