class Solution {
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, n, m);
            }
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, n, m);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, n, m);
            }
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, n, m);
            }
        }
        
        int trappedCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    trappedCount++;
                }
            }
        }
        
        return trappedCount;
    }
    
    private void dfs(int[][] grid, int r, int c, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) {
            return;
        }
        
        grid[r][c] = 0;
        
        dfs(grid, r + 1, c, n, m); // Down
        dfs(grid, r - 1, c, n, m); // Up
        dfs(grid, r, c + 1, n, m); // Right
        dfs(grid, r, c - 1, n, m); // Left
    }
}