class Solution {
    public int bitonic(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;

        int[] inc = new int[n];
        int[] dec = new int[n];

        // Initialize the base cases
        inc[0] = 1;
        dec[n - 1] = 1;

        // Build the increasing array from left to right
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Build the decreasing array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }

        // Find the maximum bitonic subarray length
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int currentLen = inc[i] + dec[i] - 1;
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }
}