class Solution {
    public long minCost(int[] heights, int[] cost) {
        int low = 1, high = 10000; 
        
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        long ans = getCost(heights, cost, low);

        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            long cost1 = getCost(heights, cost, mid1);
            long cost2 = getCost(heights, cost, mid2);

            ans = Math.min(ans, Math.min(cost1, cost2));

            if (cost1 < cost2) {
                high = mid2 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return ans;
    }

    private long getCost(int[] heights, int[] cost, int targetH) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - targetH) * cost[i];
        }
        return total;
    }
}