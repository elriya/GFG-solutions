class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int totalFlips = 0;
        int currentWindowFlips = 0;
        
        for (int i = 0; i < n; i++) {
            if (i >= k && arr[i - k] == 2) {
                currentWindowFlips--;
            }

            if ((arr[i] + currentWindowFlips) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                
                totalFlips++;
                currentWindowFlips++;
                arr[i] = 2; 
            }
        }
        
        return totalFlips;
    }
}