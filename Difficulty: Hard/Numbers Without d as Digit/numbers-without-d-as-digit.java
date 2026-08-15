import java.util.Arrays;

class Solution {
    private int[][][] memo;
    private String s;
    private int targetDigit;

    public int countWithout(int n, int d) {
        if (n <= 0) {
            return 0;
        }

        this.s = String.valueOf(n);
        this.targetDigit = d;
        int len = s.length();

        // memo[index][isTight ? 1 : 0][isLeadingZero ? 1 : 0]
        this.memo = new int[len][2][2];
        for (int[][] row2D : memo) {
            for (int[] row1D : row2D) {
                Arrays.fill(row1D, -1);
            }
        }

        return count(0, true, true);
    }

    private int count(int idx, boolean isTight, boolean isLeadingZero) {
        // Base case: if all digits were leading zeros, the number is 0 (exclude it).
        if (idx == s.length()) {
            return isLeadingZero ? 0 : 1;
        }

        int tightIdx = isTight ? 1 : 0;
        int leadIdx = isLeadingZero ? 1 : 0;

        if (memo[idx][tightIdx][leadIdx] != -1) {
            return memo[idx][tightIdx][leadIdx];
        }

        int limit = isTight ? (s.charAt(idx) - '0') : 9;
        int ans = 0;

        for (int digit = 0; digit <= limit; digit++) {
            // A digit matching targetDigit is only allowed if it's acting as a leading zero
            if (digit == targetDigit && !(isLeadingZero && digit == 0)) {
                continue;
            }

            boolean nextTight = isTight && (digit == limit);
            boolean nextLeadingZero = isLeadingZero && (digit == 0);

            ans += count(idx + 1, nextTight, nextLeadingZero);
        }

        return memo[idx][tightIdx][leadIdx] = ans;
    }
}