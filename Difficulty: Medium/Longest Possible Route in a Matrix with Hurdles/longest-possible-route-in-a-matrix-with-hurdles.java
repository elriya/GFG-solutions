class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // If the source or destination is blocked, no path can exist.
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        return findLongestPath(mat, xs, ys, xd, yd, 0);
    }
    
    private int findLongestPath(int[][] mat, int x, int y, int xd, int yd, int currentLength) {
        // Base Case: If we reached the destination, return the current path length
        if (x == xd && y == yd) {
            return currentLength;
        }
        
        // Mark the current cell as visited by setting it to 0
        mat[x][y] = 0;
        
        int maxLength = -1;
        
        // Direction vectors for moving: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            // Check boundaries and if the next cell is open (1)
            if (isValid(mat, nextX, nextY)) {
                int pathLength = findLongestPath(mat, nextX, nextY, xd, yd, currentLength + 1);
                maxLength = Math.max(maxLength, pathLength);
            }
        }
        
        // Backtrack: Unmark the current cell so it can be used in other paths
        mat[x][y] = 1;
        
        return maxLength;
    }
    
    private boolean isValid(int[][] mat, int r, int c) {
        return (r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == 1);
    }
}