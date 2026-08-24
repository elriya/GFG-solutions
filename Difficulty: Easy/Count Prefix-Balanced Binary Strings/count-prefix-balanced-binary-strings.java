class Solution {
     public int prefixStrings(int n) {
         int MOD = 1000000007;

         int[] dp = new int[n + 1];

         dp[0] = 1;

         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= i; j++) {
                 dp[j] = (dp[j] + dp[j - 1]) % MOD;
             }
         }

         return dp[n];
     }
 }