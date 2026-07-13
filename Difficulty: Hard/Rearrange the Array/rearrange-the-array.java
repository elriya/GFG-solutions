import java.util.*;

class Solution {
    int minOperations(int[] b) {
        int n = b.length;
        boolean[] visited = new boolean[n];
        
        Map<Integer, Integer> maxPrimePowers = new HashMap<>();
        
        // Find all cycle lengths
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int curr = i;
                
                while (!visited[curr]) {
                    visited[curr] = true;
                    // b[curr] is 1-based indexing, convert to 0-based index
                    curr = b[curr] - 1; 
                    length++;
                }
                
                // Decompose the cycle length into prime factors
                updatePrimePowers(length, maxPrimePowers);
            }
        }
        
        // Compute the total LCM modulo 10^9 + 7
        long ans = 1;
        long MOD = 1000000007;
        
        for (Map.Entry<Integer, Integer> entry : maxPrimePowers.entrySet()) {
            long prime = entry.getKey();
            int power = entry.getValue();
            
            // Compute (prime^power) % MOD
            long primePowerVal = powerModulo(prime, power, MOD);
            ans = (ans * primePowerVal) % MOD;
        }
        
        return (int) ans;
    }
    
    // Helper method to update the global maximum power for each prime factor
    private void updatePrimePowers(int n, Map<Integer, Integer> maxPrimePowers) {
        int temp = n;
        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                int count = 0;
                while (temp % i == 0) {
                    count++;
                    temp /= i;
                }
                maxPrimePowers.put(i, Math.max(maxPrimePowers.getOrDefault(i, 0), count));
            }
        }
        if (temp > 1) {
            maxPrimePowers.put(temp, Math.max(maxPrimePowers.getOrDefault(temp, 0), 1));
        }
    }
    
    // Helper method for fast modular exponentiation: (base^exp) % mod
    private long powerModulo(long base, int exp, long mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}