import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        int n = mat.length;
        if (n == 0) return result;
        int m = mat[0].length;
        int wordLen = word.length();
        
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean found = false;
                    
                    for (int dir = 0; dir < 8; dir++) {
                        int x = i;
                        int y = j;
                        int k = 0;
                        
                        // Check along the current direction for the whole word
                        while (k < wordLen) {
                            if (x < 0 || x >= n || y < 0 || y >= m) {
                                break; 
                            }
                            if (mat[x][y] != word.charAt(k)) {
                                break; 
                            }
                            
                            x += dx[dir];
                            y += dy[dir];
                            k++;
                        }
                        
                        if (k == wordLen) {
                            found = true;
                            break;
                        }
                    }
                    
                    // If the word is found starting from (i, j), add it to the result
                    if (found) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(i);
                        pos.add(j);
                        result.add(pos);
                    }
                }
            }
        }
        
        return result;
    }
}