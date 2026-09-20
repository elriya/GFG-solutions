class Solution {
    public int largestSubsquare(char[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;

        int[][] hor = new int[n][n];
        int[][] ver = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'X') {
                    hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
                    ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
                } else {
                    hor[i][j] = 0;
                    ver[i][j] = 0;
                }
            }
        }

        int maxSide = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int small = Math.min(hor[i][j], ver[i][j]);

                while (small > maxSide) {
                    int r = i - small + 1;
                    int c = j - small + 1;

                    if (hor[r][j] >= small && ver[i][c] >= small) {
                        maxSide = small;
                        break;
                    }
                    small--;
                }
            }
        }

        return maxSide;
    }
}