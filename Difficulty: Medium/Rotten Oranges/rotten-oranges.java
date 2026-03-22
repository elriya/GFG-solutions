import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedInThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] dir : directions) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if (r >= 0 && r < n && c >= 0 && c < m && mat[r][c] == 1) {
                        mat[r][c] = 2; 
                        freshCount--;
                        queue.offer(new int[]{r, c});
                        rottedInThisRound = true;
                    }
                }
            }
            
            if (rottedInThisRound) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }
}