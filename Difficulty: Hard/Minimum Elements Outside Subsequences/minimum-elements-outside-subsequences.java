class Solution {
    int[][][] dp;

    public int minCount(int[] arr) {
        int n = arr.length;
        dp = new int[n][102][102];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 102; j++) {
                for (int k = 0; k < 102; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        int maxIncludedElements = solve(0, 0, 101, arr);

        return n - maxIncludedElements;
    }

    private int solve(int i, int lastInc, int lastDec, int[] arr) {
        if (i == arr.length) return 0;

        if (dp[i][lastInc][lastDec] != -1) {
            return dp[i][lastInc][lastDec];
        }

        int max = solve(i + 1, lastInc, lastDec, arr); 

        if (arr[i] > lastInc) {
            max = Math.max(max, 1 + solve(i + 1, arr[i], lastDec, arr));
        }

        if (arr[i] < lastDec) {
            max = Math.max(max, 1 + solve(i + 1, lastInc, arr[i], arr));
        }

        return dp[i][lastInc][lastDec] = max;
    }
}