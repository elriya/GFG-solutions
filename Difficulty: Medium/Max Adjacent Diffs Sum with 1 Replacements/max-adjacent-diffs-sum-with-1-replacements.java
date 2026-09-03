class Solution {
    public int maxDiffSum(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0; 
        }

        int keep = 0;
        int change = 0; 

        for (int i = 1; i < arr.length; i++) {
            // max sum if we keep the current element arr[i]
            int newKeep = Math.max(
                keep + Math.abs(arr[i] - arr[i - 1]), // previous was kept
                change + Math.abs(arr[i] - 1)         // previous was changed to 1
            );

            // max sum if we change the current element to 1
            int newChange = Math.max(
                keep + Math.abs(1 - arr[i - 1]), // previous was kept
                change + 0                       // previous was changed to 1 (abs(1 - 1) = 0)
            );

            // Update the states for the next iteration
            keep = newKeep;
            change = newChange;
        }

        // maximum sum we can get by the last element
        return Math.max(keep, change);
    }
}