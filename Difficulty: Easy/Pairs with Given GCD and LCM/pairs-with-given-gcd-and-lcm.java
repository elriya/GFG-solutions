class Solution {
    public int pairCount(int x, int y) {
        if (y % x != 0) {
            return 0;
        }

        int k = y / x;
        int primeFactorsCount = 0;

        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                primeFactorsCount++;
                while (k % i == 0) {
                    k /= i;
                }
            }
        }

        if (k > 1) {
            primeFactorsCount++;
        }

        return 1 << primeFactorsCount;
    }
}