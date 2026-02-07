class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;
        long totalSum = 0;
        long currentRotationSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            currentRotationSum += (long) i * arr[i];
        }

        long maxVal = currentRotationSum;

        for (int j = 1; j < n; j++) {
            currentRotationSum = currentRotationSum + totalSum - (long) n * arr[n - j];
            
            if (currentRotationSum > maxVal) {
                maxVal = currentRotationSum;
            }
        }

        return (int) maxVal;
    }
}