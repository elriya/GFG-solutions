class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];

        // Relax all edges up to V - 1 times
        for (int i = 0; i < V - 1; i++) {
            boolean isUpdated = false;

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    isUpdated = true;
                }
            }

            if (!isUpdated) break;
        }

        // One final relaxation attempt to detect negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            if (dist[u] + w < dist[v]) {
                return true; 
            }
        }

        return false;
    }
}