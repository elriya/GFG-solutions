class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        int[] maxReach = new int[n];
        
        for (int i = 0; i < n; i++) maxReach[i] = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                maxReach[left] = Math.max(maxReach[left], right);
            }
        }

        int count = 0;
        int currEnd = -1;
        int maxEnd = -1;

        for (int i = 0; i < n; i++) {
            if (maxReach[i] != -1) {
                maxEnd = Math.max(maxEnd, maxReach[i]);
            }

            if (i > currEnd) {
                if (maxEnd < i) return -1;
                
                count++;
                currEnd = maxEnd;
                
                if (currEnd >= n - 1) return count;
            }
        }

        return (currEnd >= n - 1) ? count : -1;
    }
}