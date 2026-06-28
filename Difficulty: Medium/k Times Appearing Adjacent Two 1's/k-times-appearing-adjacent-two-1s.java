class Solution {
    public int countStrings(int n, int k) {
        // It's impossible to have k adjacent pairs if k >= n
        if (k >= n) {
            return 0;
        }

        int MOD = 1000000007;
        // dp[i][j][last]
        int[][][] dp = new int[n + 1][k + 1][2];

        // Base cases for length 1
        dp[1][0][0] = 1; 
        dp[1][0][1] = 1;

        // Build the DP table
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // Scenario 1: Appending '0'
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;

                // Scenario 2: Appending '1'
                dp[i][j][1] = dp[i - 1][j][0]; 
                if (j > 0) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][1]) % MOD; // coming from an ending '1'
                }
            }
        }

        // Total ways of length n with exactly k adjacent 1s
        return (dp[n][k][0] + dp[n][k][1]) % MOD;
    }
}