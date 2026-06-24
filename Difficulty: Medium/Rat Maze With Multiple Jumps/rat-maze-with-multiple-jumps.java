import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        
        int[][] sol = new int[n][n];
        // visited[r][c] will be true if we already know (r, c) is a dead end
        boolean[][] visited = new boolean[n][n];
        
        if (solveRatInMaze(mat, 0, 0, n, sol, visited)) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sol[i][j]);
                }
                result.add(row);
            }
            return result;
        }
        
        ArrayList<ArrayList<Integer>> noPath = new ArrayList<>();
        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(-1);
        noPath.add(inner);
        return noPath;
    }

    private boolean solveRatInMaze(int[][] mat, int r, int c, int n, int[][] sol, boolean[][] visited) {
        // Base Case: Destination reached
        if (r == n - 1 && c == n - 1) {
            sol[r][c] = 1;
            return true;
        }

        // Validate boundaries, check if blocked (0), or if it's a known dead end
        if (r >= 0 && r < n && c >= 0 && c < n && mat[r][c] != 0 && !visited[r][c]) {
            sol[r][c] = 1;
            int maxJump = mat[r][c];

            // Prioritize shorter jumps and Right over Down
            for (int k = 1; k <= maxJump; k++) {
                // Move Right
                if (solveRatInMaze(mat, r, c + k, n, sol, visited)) {
                    return true;
                }
                // Move Down
                if (solveRatInMaze(mat, r + k, c, n, sol, visited)) {
                    return true;
                }
            }

            // Backtrack: This cell does not lead to a solution
            sol[r][c] = 0;
            // Memoize: Mark as a dead end so we never waste time exploring it again
            visited[r][c] = true;
        }
        
        return false;
    }
}