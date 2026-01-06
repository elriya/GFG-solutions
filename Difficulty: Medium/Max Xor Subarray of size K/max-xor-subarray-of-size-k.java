class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return 0;

        int currentXor = 0;
        
        for (int i = 0; i < k; i++) {
            currentXor ^= arr[i];
        }

        int maxXor = currentXor;

        for (int i = k; i < n; i++) {
            currentXor = currentXor ^ arr[i - k] ^ arr[i];
            
            if (currentXor > maxXor) {
                maxXor = currentXor;
            }
        }

        return maxXor;
    }
}