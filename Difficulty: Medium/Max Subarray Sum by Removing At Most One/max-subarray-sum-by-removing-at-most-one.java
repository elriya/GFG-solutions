class Solution {
    public int maxSumSubarray(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int maxNormal = arr[0];
        int maxIgnored = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {
            maxIgnored = Math.max(maxNormal, maxIgnored + arr[i]);
            
            maxNormal = Math.max(arr[i], maxNormal + arr[i]);

            overallMax = Math.max(overallMax, Math.max(maxNormal, maxIgnored));
        }

        return overallMax;
    }
}