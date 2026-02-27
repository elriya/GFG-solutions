class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        long[][] pref = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }

        for (int k = 1; k <= Math.min(n, m); k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    
                    int r2 = i + k - 1;
                    int c2 = j + k - 1;

                    long currentSum = pref[r2 + 1][c2 + 1] - pref[i][c2 + 1] - pref[r2 + 1][j] + pref[i][j];

                    if (currentSum == x) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}