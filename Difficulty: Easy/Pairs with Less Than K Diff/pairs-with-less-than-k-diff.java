import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {
        if (arr == null || arr.length < 2 || k <= 0) {
            return 0;
        }

        // Sort the array to use two-pointer technique
        Arrays.sort(arr);

        int n = arr.length;
        long totalPairs = 0; // Use long to prevent integer overflow
        int j = 0;

        for (int i = 0; i < n; i++) {
            // Move j to the furthest index where arr[j] - arr[i] < k
            while (j < n && arr[j] - arr[i] < k) {
                j++;
            }
            // All elements between index i + 1 and j - 1 form valid pairs with arr[i]
            totalPairs += (j - 1 - i);
        }

        return (int) totalPairs;
    }
}