class Solution {
    public int countSubsets(int[] arr) {
        int MOD = 1_000_000_007;
        
        // Primes up to 30 (10 primes total)
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        
        // Count frequencies of each number in arr
        int[] freq = new int[31];
        for (int x : arr) {
            freq[x]++;
        }
        
        // Precompute prime bitmasks for numbers 1..30
        int[] mask = new int[31];
        for (int i = 2; i <= 30; i++) {
            int num = i;
            int bitmask = 0;
            boolean squareFree = true;
            
            for (int j = 0; j < 10; j++) {
                int p = primes[j];
                if (num % p == 0) {
                    num /= p;
                    if (num % p == 0) { // Has duplicate prime factor
                        squareFree = false;
                        break;
                    }
                    bitmask |= (1 << j);
                }
            }
            if (squareFree) {
                mask[i] = bitmask;
            } else {
                mask[i] = -1; // Ignore numbers divisible by a square (e.g., 4, 8, 9, 12...)
            }
        }
        
        // dp[mask] = number of valid subsets with prime bitmask equal to 'mask'
        long[] dp = new long[1 << 10];
        dp[0] = 1;
        
        // Process numbers 2 through 30
        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0 || mask[i] == -1) continue;
            
            int numMask = mask[i];
            int count = freq[i];
            
            for (int currentMask = (1 << 10) - 1; currentMask >= 0; currentMask--) {
                if ((currentMask & numMask) == 0) { // No overlapping prime factors
                    int nextMask = currentMask | numMask;
                    dp[nextMask] = (dp[nextMask] + dp[currentMask] * count) % MOD;
                }
            }
        }
        
        // Sum up all valid non-empty subset combinations
        long totalValid = 0;
        for (int m = 1; m < (1 << 10); m++) {
            totalValid = (totalValid + dp[m]) % MOD;
        }
        
        // Multiply by 2^(freq[1]) because 1 can be included/excluded freely
        long onesPower = 1;
        for (int i = 0; i < freq[1]; i++) {
            onesPower = (onesPower * 2) % MOD;
        }
        
        return (int) ((totalValid * onesPower) % MOD);
    }
}