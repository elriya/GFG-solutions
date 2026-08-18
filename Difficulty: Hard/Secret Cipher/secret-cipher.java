class Solution {
    public String compress(String s) {
        int n = s.length();
        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];

        // Hashing configs
        long BASE = 313;
        long MOD = 1000000007;

        power[0] = 1;
        // Precompute prefix hashes and polynomial powers
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * BASE + s.charAt(i)) % MOD;
            power[i + 1] = (power[i] * BASE) % MOD;
        }

        StringBuilder ans = new StringBuilder();
        int len = n;

        // Greedily compress the string evaluating from right to left
        while (len > 0) {
            if (len % 2 == 0) {
                int k = len / 2;

                // Get the hash of the first half
                long h1 = hash[k]; 

                // Get the hash of the second half
                long h2 = (hash[len] - hash[k] * power[k]) % MOD;
                if (h2 < 0) h2 += MOD; // Handle negative mod results

                // If hashes match, verify character by character to bypass hash collisions
                if (h1 == h2) {
                    boolean match = true;
                    for (int i = 0; i < k; i++) {
                        if (s.charAt(i) != s.charAt(k + i)) {
                            match = false;
                            break;
                        }
                    }

                    if (match) {
                        ans.append('*');
                        len = k;     // Cut the effective length in half
                        continue;
                    }
                }
            }

            // Revert back safely if no identical halves found / length was odd
            ans.append(s.charAt(len - 1));
            len--;
        }

        // Since we iterated and appended from right to left, reversing yields the correct order
        return ans.reverse().toString();
    }
}