import java.util.*;

class Solution {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Distance array initialized to infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Min-Heap ordered by current shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.weight;

            // Early exit if destination reached
            if (u == dest) {
                return d;
            }

            // Skip processing if a shorter path to u has already been processed
            if (d > dist[u]) {
                continue;
            }

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}