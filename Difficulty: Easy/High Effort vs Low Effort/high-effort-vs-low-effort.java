class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        if (n == 0) return 0;

        int prevPrev = 0; // dp[i-2]
        int prev = 0;     // dp[i-1]

        for (int i = 0; i < n; i++) {
            int takeHigh = prevPrev + h[i]; // perform high-effort task
            int takeLow = prev + l[i];      // perform low-effort task

            int current = Math.max(takeHigh, takeLow);

            prevPrev = prev;
            prev = current;
        }

        return prev;
    }
}