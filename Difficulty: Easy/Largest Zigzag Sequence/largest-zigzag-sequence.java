class Solution {
    public int zigzagSequence(int[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        if (n == 1) return mat[0][0];

        // Track the max and second max values from the previous row
        int prevMax1 = 0, prevMax2 = 0;
        int prevMaxCol1 = -1;

        // Initialize with the first row
        for (int j = 0; j < n; j++) {
            int val = mat[0][j];
            if (val > prevMax1) {
                prevMax2 = prevMax1;
                prevMax1 = val;
                prevMaxCol1 = j;
            } else if (val > prevMax2) {
                prevMax2 = val;
            }
        }

        // Process row by row from row 1 to row n-1
        for (int i = 1; i < n; i++) {
            int currMax1 = 0, currMax2 = 0;
            int currMaxCol1 = -1;

            for (int j = 0; j < n; j++) {
                // Choose the best from previous row that isn't in column j
                int maxPrev = (j == prevMaxCol1) ? prevMax2 : prevMax1;
                int currentSum = mat[i][j] + maxPrev;

                // Update max1 and max2 for the current row
                if (currentSum > currMax1) {
                    currMax2 = currMax1;
                    currMax1 = currentSum;
                    currMaxCol1 = j;
                } else if (currentSum > currMax2) {
                    currMax2 = currentSum;
                }
            }

            // Move current row's stats to previous row's stats
            prevMax1 = currMax1;
            prevMax2 = currMax2;
            prevMaxCol1 = currMaxCol1;
        }

        return prevMax1;
    }
}