class Solution {
    public int countSubsequences(String s, int n) {
        int MOD = 1000000007;

        int[] dp = new int[n];

        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            int[] nextDp = new int[n];

            for (int j = 0; j < n; j++) {
                nextDp[j] = dp[j];
            }

            for (int j = 0; j < n; j++) {
                if (dp[j] > 0) {
                    int newRem = (j * 10 + d) % n;
                    nextDp[newRem] = (nextDp[newRem] + dp[j]) % MOD;
                }
            }

            nextDp[d % n] = (nextDp[d % n] + 1) % MOD;

            dp = nextDp;
        }

        return dp[0];
    }
}