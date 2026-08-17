import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int target = n * n;
        
        // Base case: if the board only has 1 cell
        if (target == 1) return 0;
        
        // Array to store shortcuts (ladders or snakes)
        int[] jump = new int[target + 1];
        
        // Populate ladders
        if (lad != null) {
            for (int i = 0; i < lad.length; i += 2) {
                jump[lad[i]] = lad[i + 1];
            }
        }
        
        // Populate snakes
        if (sn != null) {
            for (int i = 0; i < sn.length; i += 2) {
                jump[sn[i]] = sn[i + 1];
            }
        }
        
        // Array to store the minimum dice throws to reach each cell
        int[] dist = new int[target + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0; // 0 throws to reach the start
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        
        // Breadth-First Search
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            // Loop through all possible dice rolls (1 to 6)
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                
                // If the next cell goes beyond the board, ignore further rolls
                if (next > target) break;
                
                // Check if the cell has a ladder or a snake; otherwise, stay on the cell
                int dest = (jump[next] != 0) ? jump[next] : next;
                
                // If the destination cell hasn't been visited yet
                if (dist[dest] == -1) {
                    dist[dest] = dist[curr] + 1;
                    
                    // If we reach the last cell, we can return the throw count immediately
                    if (dest == target) return dist[dest];
                    
                    q.add(dest);
                }
            }
        }
        
        // If the queue is exhausted and target was never reached
        return -1;
    }
}