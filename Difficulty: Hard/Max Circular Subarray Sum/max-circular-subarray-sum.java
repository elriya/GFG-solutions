class Solution {
    public int maxCircularSum(int arr[]) {
        int totalSum = 0;
        int currentMax = 0, maxKadane = Integer.MIN_VALUE;
        int currentMin = 0, minKadane = Integer.MAX_VALUE;

        for (int x : arr) {
            currentMax += x;
            maxKadane = Math.max(maxKadane, currentMax);
            if (currentMax < 0) currentMax = 0;

            currentMin += x;
            minKadane = Math.min(minKadane, currentMin);
            if (currentMin > 0) currentMin = 0;

            totalSum += x;
        }

        if (maxKadane < 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, totalSum - minKadane);
    }
}