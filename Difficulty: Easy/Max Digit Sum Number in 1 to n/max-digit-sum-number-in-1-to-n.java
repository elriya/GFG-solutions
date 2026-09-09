class Solution {
    public int findMax(int n) {
        int maxSum = getSum(n);
        int bestNum = n;

        long p10 = 10; 
        
        while (n >= p10 / 10) {
            long candidate = (n / p10 - 1) * p10 + (p10 - 1);

            if (candidate > 0) {
                int sum = getSum((int) candidate);

                if (sum > maxSum || (sum == maxSum && candidate > bestNum)) {
                    maxSum = sum;
                    bestNum = (int) candidate;
                }
            }

            p10 *= 10;
        }

        return bestNum;
    }

    private int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}