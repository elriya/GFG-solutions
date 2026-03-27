class Solution {
    public int maxChocolate(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;
        
        Integer[][][] memo = new Integer[n][m][m];
        
        return solve(0, 0, m - 1, grid, n, m, memo);
    }

    private int solve(int r, int c1, int c2, int[][] grid, int n, int m, Integer[][][] memo) {
        if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) {
            return (int) -1e9; 
        }

        if (r == n - 1) {
            if (c1 == c2) return grid[r][c1];
            else return grid[r][c1] + grid[r][c2];
        }

        if (memo[r][c1][c2] != null) {
            return memo[r][c1][c2];
        }

        int chocolates = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];

        int maxFuture = 0;
        for (int i = -1; i <= 1; i++) {    
            for (int j = -1; j <= 1; j++) { 
                maxFuture = Math.max(maxFuture, solve(r + 1, c1 + i, c2 + j, grid, n, m, memo));
            }
        }

        return memo[r][c1][c2] = chocolates + maxFuture;
    }
}