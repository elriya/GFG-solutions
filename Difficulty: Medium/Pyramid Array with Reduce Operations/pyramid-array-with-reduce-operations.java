class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long totalSum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        totalSum += arr[0];
        for (int i = 1; i < n; i++) {
            totalSum += arr[i];
            left[i] = Math.min(arr[i], left[i - 1] + 1);
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long maxPyramidSum = 0;

        for (int i = 0; i < n; i++) {
            long peak = Math.min(left[i], right[i]);
            long pyramidSum = peak * peak;
            maxPyramidSum = Math.max(maxPyramidSum, pyramidSum);
        }

        return (int) (totalSum - maxPyramidSum);
    }
}