class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1) return 0;
        
        int[] firstBfs = bfs(1, n, adj);
        int farthestNode = firstBfs[0];
        
        int[] secondBfs = bfs(farthestNode, n, adj);
        int diameter = secondBfs[1];
        
        return (diameter + 1) / 2;
    }
    
    private int[] bfs(int start, int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        java.util.Queue<Integer> distQueue = new java.util.LinkedList<>();
        
        queue.add(start);
        distQueue.add(0);
        visited[start] = true;
        
        int farthestNode = start;
        int maxDist = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int dist = distQueue.poll();
            
            if (dist > maxDist) {
                maxDist = dist;
                farthestNode = curr;
            }
            
            for (int neighbor : adj.get(curr - 1)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distQueue.add(dist + 1);
                }
            }
        }
        
        return new int[] { farthestNode, maxDist };
    }
}