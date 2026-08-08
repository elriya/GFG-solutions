class Solution {
    class DSU {
        int[] parent;
        
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]); // Path compression
        }
        
        void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }

    public int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;
        
        // A connected graph of n vertices must have at least n - 1 edges
        if (m < n - 1) {
            return -1;
        }

        DSU dsu = new DSU(n);
        int components = n;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                components--; // Joining two components reduces the total count by 1
            }
        }

        return components - 1;
    }
}