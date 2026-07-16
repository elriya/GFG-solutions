import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int countWays(int n, int sum) {
        // A single digit can only sum up to 9, and the maximum sum for n digits is 9 * n.
        if (sum < 1 || sum > 9 * n) {
            return -1;
        }

        // Initialize DP memoization table: n + 1 positions, sum + 1 targets
        memo = new int[n + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int totalWays = 0;

        // The first digit must be between 1 and 9 (no leading zeroes)
        for (int digit = 1; digit <= 9; digit++) {
            if (sum - digit >= 0) {
                totalWays += solve(2, n, sum - digit);
            }
        }

        return totalWays == 0 ? -1 : totalWays;
    }

    private int solve(int digitIndex, int n, int remainingSum) {
        // Base Case: If we have placed all n digits
        if (digitIndex > n) {
            return remainingSum == 0 ? 1 : 0;
        }

        // If the remaining sum is negative, it's impossible to form a valid sum
        if (remainingSum < 0) {
            return 0;
        }

        // Return cached result if already calculated
        if (memo[digitIndex][remainingSum] != -1) {
            return memo[digitIndex][remainingSum];
        }

        int ways = 0;
        // Subsequent digits (from index 2 to n) can range from 0 to 9
        for (int digit = 0; digit <= 9; digit++) {
            ways += solve(digitIndex + 1, n, remainingSum - digit);
        }

        return memo[digitIndex][remainingSum] = ways;
    }
}