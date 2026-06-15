class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];
        
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            int currentCost = cost[i - 1];
            
            if (currentCost != -1) {
                for (int j = i; j <= w; j++) {
                    if (dp[j - i] != INF) {
                        dp[j] = Math.min(dp[j], dp[j - i] + currentCost);
                    }
                }
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}