class Solution {
    public int findCoverage(int[][] mat) {
        int totalCoverage = 0;
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    
                    for (int r = i - 1; r >= 0; r--) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break; 
                        }
                    }

                    for (int r = i + 1; r < rows; r++) {
                        if (mat[r][j] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }

                    for (int c = j - 1; c >= 0; c--) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }

                    for (int c = j + 1; c < cols; c++) {
                        if (mat[i][c] == 1) {
                            totalCoverage++;
                            break;
                        }
                    }
                }
            }
        }

        return totalCoverage;
    }
}