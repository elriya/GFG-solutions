class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        long low = 1;
        long high = 2000000000L; 
        int result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                result = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean canAchieve(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long currentAddedHeight = 0;
        long daysUsed = 0;

        for (int i = 0; i < n; i++) {
            currentAddedHeight += diff[i];
            long currentHeight = arr[i] + currentAddedHeight;

            if (currentHeight < target) {
                long needed = target - currentHeight;
                daysUsed += needed;
                
                if (daysUsed > k) return false;

                currentAddedHeight += needed;
                if (i + w < n) {
                    diff[i + w] -= needed;
                }
            }
        }

        return daysUsed <= k;
    }
}