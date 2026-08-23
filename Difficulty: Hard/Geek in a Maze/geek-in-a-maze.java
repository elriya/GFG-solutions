class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        
        // Cannot start on an obstacle
        if (mat[r][c] == '#') return 0;
        
        // Tracks the minimum upward moves (U) required to reach each cell
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Custom array-based Deque for 0-1 BFS to avoid object allocation overhead
        int[] dq = new int[n * m * 2 + 1];
        int head = n * m;
        int tail = head - 1;
        
        dq[++tail] = r * m + c;
        dist[r][c] = 0;
        
        // Directions: Up, Down, Left, Right
        // Moving UP costs 1 (increases U), all other directions cost 0
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] cost = {1, 0, 0, 0}; 
        
        while (head <= tail) {
            int curr = dq[head++];
            int x = curr / m;
            int y = curr % m;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && mat[nx][ny] != '#') {
                    int ncost = dist[x][y] + cost[i];
                    
                    // If we found a path with fewer upward moves
                    if (ncost < dist[nx][ny]) {
                        dist[nx][ny] = ncost;
                        
                        // 0-cost moves go to the front, 1-cost moves go to the back
                        if (cost[i] == 0) {
                            dq[--head] = nx * m + ny;
                        } else {
                            dq[++tail] = nx * m + ny;
                        }
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    int U = dist[i][j];
                    // Derived formula: Down moves = Up moves + net vertical displacement
                    int D = U + i - r; 
                    
                    if (U <= u && D <= d) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}