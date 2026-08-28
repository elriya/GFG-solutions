class Solution {
    public int minCost(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int c0 = mat[0][0];
        int c1 = mat[0][1];
        int c2 = mat[0][2];

        for (int i = 1; i < mat.length; i++) {
            int nextC0 = mat[i][0] + Math.min(c1, c2);
            int nextC1 = mat[i][1] + Math.min(c0, c2);
            int nextC2 = mat[i][2] + Math.min(c0, c1);

            c0 = nextC0;
            c1 = nextC1;
            c2 = nextC2;
        }

        return Math.min(c0, Math.min(c1, c2));
    }
}