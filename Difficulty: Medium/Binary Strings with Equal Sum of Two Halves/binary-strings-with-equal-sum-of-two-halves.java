class Solution {
    private static final int MOD = 1000000007;

    public int computeValue(int n) {
        long num = factorial(2 * n);
        long den = factorial(n);
        
        den = (den * den) % MOD;
        
        long ans = (num * modInverse(den, MOD)) % MOD;
        
        return (int) ans;
    }

    private long factorial(int max) {
        long fact = 1;
        for (int i = 1; i <= max; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    private long power(long base, long exp, long mod) {
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

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }
}