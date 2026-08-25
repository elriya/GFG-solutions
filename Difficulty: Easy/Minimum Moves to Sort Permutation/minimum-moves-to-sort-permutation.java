class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            dp[num] = dp[num - 1] + 1;

            if (dp[num] > maxLen) {
                maxLen = dp[num];
            }
        }

        return n - maxLen;
    }
}