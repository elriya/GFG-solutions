import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] safe = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                safe[i][j] = true;
            }
        }
        
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    safe[i][j] = false;
                    
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dRow[k];
                        int nj = j + dCol[k];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            safe[ni][nj] = false;
                        }
                    }
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1 && safe[i][0]) {
                queue.add(new int[] {i, 0, 0}); 
                visited[i][0] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            if (c == m - 1) {
                return dist + 1; 
            }
            
            for (int k = 0; k < 4; k++) {
                int nr = r + dRow[k];
                int nc = c + dCol[k];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && safe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}