class Solution {
    public int palindromicStrings(int n, int k) {
        long ans = 0;
        long mod = 1_000_000_007;

        for (int L = 1; L <= n; L++) {
            int requiredDistinct = (L + 1) / 2;

            if (requiredDistinct > k) {
                continue;
            }

            long ways = 1;
            for (int i = 0; i < requiredDistinct; i++) {
                ways = (ways * (k - i)) % mod;
            }

            ans = (ans + ways) % mod;
        }

        return (int) ans;
    }
}