import java.util.*;

class Solution {
    public int findMotherVertex(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        int lastFinishedVertex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastFinishedVertex = i;
            }
        }

        Arrays.fill(visited, false);
        int count = dfsCount(lastFinishedVertex, adj, visited);

        if (count == V) {
            int smallestMother = lastFinishedVertex;
            for (int i = 0; i < V; i++) {
                Arrays.fill(visited, false);
                if (dfsCount(i, adj, visited) == V) {
                    return i;
                }
            }
            return lastFinishedVertex; 
        }

        return -1;
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }

    private int dfsCount(int u, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        int count = 1;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                count += dfsCount(v, adj, visited);
            }
        }
        return count;
    }
}