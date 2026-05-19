import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int minSteps(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }

        int MOD = 1000;
        
        int[] steps = new int[MOD];
        Arrays.fill(steps, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        steps[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int num : arr) {
                int next = (current * num) % MOD;
                
                if (steps[next] == -1) {
                    steps[next] = steps[current] + 1;
                    
                    if (next == end) {
                        return steps[next];
                    }
                    
                    queue.add(next);
                }
            }
        }
        
        return -1;
    }
}