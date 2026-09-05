class Solution {
    public int longestSubseq(int[] arr) {
        int maxVal = 0;
        for (int x : arr) maxVal = Math.max(maxVal, x);

        int[] dp = new int[maxVal + 2];
        int maxLen = 0;

        for (int x : arr) {
            dp[x] = Math.max(dp[x - 1], dp[x + 1]) + 1;
            maxLen = Math.max(maxLen, dp[x]);
        }

        return maxLen;
    }
}