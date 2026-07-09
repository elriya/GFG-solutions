class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // Array to store the frequencies of remainders
        long[] remFreq = new long[k];
        
        // Count frequencies of each remainder
        for (int num : arr) {
            int rem = num % k;
            remFreq[rem]++;
        }
        
        int count = 0;
        
        // Pairs where both elements have a remainder of 0
        count += (remFreq[0] * (remFreq[0] - 1)) / 2;
    
        // Pairs where remainders add up to k
        for (int r = 1; r <= k / 2; r++) {
            if (r == k - r) {
                // If k is even and r is exactly k / 2, pair within itself
                count += (remFreq[r] * (remFreq[r] - 1)) / 2;
            } else {
                // Pair remainder r with remainder k - r
                count += remFreq[r] * remFreq[k - r];
            }
        }
        
        return count;
    }
}