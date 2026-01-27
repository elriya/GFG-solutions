class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] mat, int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = mat[r][c];
        mat[r][c] = '#'; 

        boolean found = dfs(mat, r + 1, c, word, index + 1) ||
                        dfs(mat, r - 1, c, word, index + 1) ||
                        dfs(mat, r, c + 1, word, index + 1) ||
                        dfs(mat, r, c - 1, word, index + 1);

        mat[r][c] = temp;

        return found;
    }
}