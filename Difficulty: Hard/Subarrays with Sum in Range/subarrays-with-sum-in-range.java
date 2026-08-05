class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        return countSubarraysWithSumAtMost(arr, r) - countSubarraysWithSumAtMost(arr, l - 1);
    }

    private int countSubarraysWithSumAtMost(int[] arr, long K) {
        if (K < 0) return 0;
        
        int count = 0;
        int left = 0;
        long currentSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (left <= right && currentSum > K) {
                currentSum -= arr[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}