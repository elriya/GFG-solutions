class Solution {
    static int noOfWays(int m, int n, int x) {
        long[][] dp = new long[n + 1][x + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) { 
            for (int j = 1; j <= x; j++) { 
                for (int k = 1; k <= m && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
                if(j <= m && i == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        return (int) dp[n][x];
    }
};