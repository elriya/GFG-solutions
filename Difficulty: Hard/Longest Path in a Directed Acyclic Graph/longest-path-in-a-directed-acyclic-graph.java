import java.util.*;

class Solution {
    // Helper class to represent a directed edge
    private static class Edge {
        int v;
        int weight;

        Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    public int[] maxDistance(int V, int src, ArrayList<ArrayList<Integer>> edges) {
        // Build Adjacency List
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new Edge(v, w));
        }

        // Perform Topological Sort using DFS
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adj);
            }
        }

        // Initialize distance array with INT_MIN
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0; // Distance to source is 0

        // Relax edges in Topological Order
        while (!stack.isEmpty()) {
            int u = stack.pop();

            // Relax outgoing edges only if vertex u is reachable
            if (dist[u] != Integer.MIN_VALUE) {
                for (Edge neighbor : adj.get(u)) {
                    if (dist[u] + neighbor.weight > dist[neighbor.v]) {
                        dist[neighbor.v] = dist[u] + neighbor.weight;
                    }
                }
            }
        }

        return dist;
    }

    private void topologicalSortUtil(int u, boolean[] visited, Stack<Integer> stack, List<List<Edge>> adj) {
        visited[u] = true;
        for (Edge neighbor : adj.get(u)) {
            if (!visited[neighbor.v]) {
                topologicalSortUtil(neighbor.v, visited, stack, adj);
            }
        }
        stack.push(u);
    }
}