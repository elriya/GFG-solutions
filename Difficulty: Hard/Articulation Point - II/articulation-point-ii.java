import java.util.*;

class Solution {
    private int timer = 0;

    public ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAP = new boolean[V]; 
        
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, disc, low, visited, isAP);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) result.add(i);
        }

        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    private void dfs(int u, int p, ArrayList<ArrayList<Integer>> adj, 
                     int[] disc, int[] low, boolean[] visited, boolean[] isAP) {
        
        visited[u] = true;
        disc[u] = low[u] = ++timer;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == p) continue; 

            if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                children++;
                dfs(v, u, adj, disc, low, visited, isAP);
                
                low[u] = Math.min(low[u], low[v]);

                if (p != -1 && low[v] >= disc[u]) {
                    isAP[u] = true;
                }
            }
        }

        if (p == -1 && children > 1) {
            isAP[u] = true;
        }
    }
}