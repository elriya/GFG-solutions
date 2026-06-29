class Solution {
    public int maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                int exclude = dp[i - 1][j];
                
                int include = dp[i - 1][j - 1] + a[i - 1] * b[j - 1];
                
                dp[i][j] = Math.max(exclude, include);
            }
        }
        
        return dp[n][m];
    }
}