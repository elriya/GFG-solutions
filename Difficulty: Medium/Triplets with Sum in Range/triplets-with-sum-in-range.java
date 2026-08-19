import java.util.Arrays;

class Solution {
    public int countTriplets(int[] arr, int l, int r) {
        Arrays.sort(arr);
        // ans is triplets <= r minus triplets < l
        return countLessOrEqual(arr, r) - countLessOrEqual(arr, l - 1);
    }

    private int countLessOrEqual(int[] arr, int target) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum <= target) {
                    // if this right works, everything in between works too
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}