class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;
        
        // Optimization: Pigeonhole Principle guarantee
        if (n >= k) {
            return true;
        }
        
        boolean[] dp = new boolean[k];
        
        for (int num : arr) {
            int rem = num % k;
            
            if (rem == 0) {
                return true;
            }
            
            boolean[] nextDp = dp.clone();
            
            nextDp[rem] = true;
            
            // Combine 'rem' with all previously achievable remainders
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    int newRem = (r + rem) % k;
                    nextDp[newRem] = true;
                }
            }
            
            // If we managed to create a subset with remainder 0, we can exit early
            if (nextDp[0]) {
                return true;
            }
            
            dp = nextDp;
        }
        
        return dp[0];
    }
}