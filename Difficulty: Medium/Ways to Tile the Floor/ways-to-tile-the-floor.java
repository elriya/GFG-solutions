class Solution {
    public int countWays(int n, int m) {
        if (n < m) {
            return 1;
        }

        int MOD = 1000000007;
        int[] dp = new int[n + 1];

        // Base cases for i < m
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        
        // Base case for i == m
        dp[m] = 2;

        // Fill the DP table using the recurrence relation
        for (int i = m + 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - m]) % MOD;
        }

        return dp[n];
    }
}