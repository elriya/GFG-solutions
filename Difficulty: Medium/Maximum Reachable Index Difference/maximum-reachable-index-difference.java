class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] dp = new int[n];
        
        // Track maximum reachable index for each character 'a' through 'z'
        int[] maxReach = new int[26];
        for (int k = 0; k < 26; k++) {
            maxReach[k] = -1;
        }
        
        int maxDiff = -1;
        
        // Fill DP array from right to left
        for (int i = n - 1; i >= 0; i--) {
            int charIdx = s.charAt(i) - 'a';
            
            // Base case: farthest index is itself
            dp[i] = i;
            
            // If next character in alphabet exists to the right, jump to its max reach
            if (charIdx < 25 && maxReach[charIdx + 1] != -1) {
                dp[i] = maxReach[charIdx + 1];
            }
            
            // Update the maximum reach for current character
            maxReach[charIdx] = Math.max(maxReach[charIdx], dp[i]);
        }
        
        // Compute maximum difference for all starting 'a's
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                maxDiff = Math.max(maxDiff, dp[i] - i);
            }
        }
        
        return maxDiff;
    }
}