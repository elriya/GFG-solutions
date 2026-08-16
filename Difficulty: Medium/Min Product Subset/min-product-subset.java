class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;

        // Base case: only one element
        if (n == 1) {
            return arr[0];
        }

        int countNeg = 0;
        int countZero = 0;
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int prod = 1;

        for (int x : arr) {
            if (x == 0) {
                countZero++;
                continue;
            }

            if (x < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, x);
            } else {
                minPos = Math.min(minPos, x);
            }

            prod *= x;
        }

        // No negative numbers present
        if (countNeg == 0) {
            if (countZero > 0) {
                return 0;
            }
            return minPos;
        }

        // Even number of negative numbers
        if (countNeg % 2 == 0) {
            // Remove the negative number with the smallest magnitude to maximize negativity
            prod /= maxNeg;
        }

        return prod;
    }
}