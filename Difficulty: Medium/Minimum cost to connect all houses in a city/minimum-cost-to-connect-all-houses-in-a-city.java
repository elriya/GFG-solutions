class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        int totalCost = 0;
        int nodesConnected = 0;
        
        int[] minDist = new int[n];
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        boolean[] inMST = new boolean[n];
        minDist[0] = 0; 

        while (nodesConnected < n) {
            int currHouse = -1;
            int minVal = Integer.MAX_VALUE;

            // Find the house with the minimum distance to the current MST
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minDist[i] < minVal) {
                    minVal = minDist[i];
                    currHouse = i;
                }
            }

            // Add this house to MST
            inMST[currHouse] = true;
            totalCost += minVal;
            nodesConnected++;

            // Update distances to neighboring houses
            for (int nextHouse = 0; nextHouse < n; nextHouse++) {
                if (!inMST[nextHouse]) {
                    int dist = Math.abs(houses[currHouse][0] - houses[nextHouse][0]) +
                               Math.abs(houses[currHouse][1] - houses[nextHouse][1]);
                    
                    if (dist < minDist[nextHouse]) {
                        minDist[nextHouse] = dist;
                    }
                }
            }
        }

        return totalCost;
    }
}