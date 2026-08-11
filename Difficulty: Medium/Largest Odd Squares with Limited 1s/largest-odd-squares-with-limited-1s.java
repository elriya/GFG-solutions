import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Build 2D Prefix Sum Array
        // pref[r][c] stores the sum of mat[0..r-1][0..c-1]
        int[][] pref = new int[n + 1][m + 1];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                pref[r + 1][c + 1] = mat[r][c] + pref[r][c + 1] + pref[r + 1][c] - pref[r][c];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Process each query using Binary Search
        for (int[] q : queries) {
            int i = q[0];
            int j = q[1];

            // Maximum radius such that the square stays within matrix boundaries
            int maxR = Math.min(Math.min(i, n - 1 - i), Math.min(j, m - 1 - j));

            int low = 0, high = maxR;
            int bestSideLength = -1;

            while (low <= high) {
                int midR = low + (high - low) / 2;

                int r1 = i - midR;
                int c1 = j - midR;
                int r2 = i + midR;
                int c2 = j + midR;

                // Query the count of 1s in 1-indexed pref array
                int ones = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];

                if (ones <= k) {
                    bestSideLength = 2 * midR + 1; // Valid, record side length and try larger radius
                    low = midR + 1;
                } else {
                    high = midR - 1; // Exceeds k ones, try smaller radius
                }
            }

            result.add(bestSideLength);
        }

        return result;
    }
}