class Solution {
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n) || d % gcd(m, n) != 0) {
            return -1;
        }

        return Math.min(getSteps(m, n, d), getSteps(n, m, d));
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int getSteps(int fromCap, int toCap, int d) {
        int from = 0; 
        int to = 0;   
        int steps = 0;

        while (from != d && to != d) {
            if (from == 0) {
                from = fromCap;
                steps++;
            } else if (to == toCap) {
                to = 0;
                steps++;
            } else {
                int transfer = Math.min(from, toCap - to);
                to += transfer;
                from -= transfer;
                steps++;
            }
        }
        return steps;
    }
}