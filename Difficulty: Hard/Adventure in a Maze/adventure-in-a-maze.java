import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        long MOD = 1000000007;

        long[][] paths = new long[n][n];
        int[][] maxAdv = new int[n][n];

        // Base case initialization
        paths[0][0] = 1;
        maxAdv[0][0] = grid[0][0];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // Skip unreachable cells
                if (paths[r][c] == 0) {
                    continue;
                }

                int val = grid[r][c];

                // Right Move (Available for cell values 1 and 3)
                if ((val == 1 || val == 3) && c + 1 < n) {
                    // Update total paths
                    paths[r][c + 1] = (paths[r][c + 1] + paths[r][c]) % MOD;
                    // Update maximum adventure
                    maxAdv[r][c + 1] = Math.max(maxAdv[r][c + 1], maxAdv[r][c] + grid[r][c + 1]);
                }

                // Down Move (Available for cell values 2 and 3)
                if ((val == 2 || val == 3) && r + 1 < n) {
                    // Update total paths
                    paths[r + 1][c] = (paths[r + 1][c] + paths[r][c]) % MOD;
                    // Update maximum adventure
                    maxAdv[r + 1][c] = Math.max(maxAdv[r + 1][c], maxAdv[r][c] + grid[r + 1][c]);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) paths[n - 1][n - 1]);
        result.add(maxAdv[n - 1][n - 1]);

        return result;
    }
}