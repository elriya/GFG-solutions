class Solution {
    int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}