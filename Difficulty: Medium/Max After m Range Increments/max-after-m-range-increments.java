class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // Initialize the difference array
        // Using long array to prevent integer overflow during prefix sum updates
        long[] diff = new long[n];
        int m = a.length;

        // Apply difference updates
        for (int i = 0; i < m; i++) {
            int start = a[i];
            int end = b[i];
            int val = k[i];

            diff[start] += val;
            if (end + 1 < n) {
                diff[end + 1] -= val;
            }
        }

        // Compute prefix sum and track maximum element
        long maxVal = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            if (currentSum > maxVal) {
                maxVal = currentSum;
            }
        }

        return (int) maxVal;
    }
}