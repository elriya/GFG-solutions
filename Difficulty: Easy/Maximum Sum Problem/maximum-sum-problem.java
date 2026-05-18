class Solution {
    public int maxSum(int n) {
        if (n == 0) return 0;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            int noBreak = i;
            
            int breakDown = dp[i / 2] + dp[i / 3] + dp[i / 4];
            
            dp[i] = Math.max(noBreak, breakDown);
        }
        
        return dp[n];
    }
}