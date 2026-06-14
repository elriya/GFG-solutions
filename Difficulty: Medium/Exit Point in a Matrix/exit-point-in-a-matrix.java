import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = 0, c = 0; 
        int d = 0;      
        
        int lastR = 0, lastC = 0;
        
        while (r >= 0 && r < n && c >= 0 && c < m) {
            lastR = r;
            lastC = c;
            
            if (mat[r][c] == 1) {
                d = (d + 1) % 4;
                mat[r][c] = 0;
            }
            
            r += dr[d];
            c += dc[d];
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(lastR);
        ans.add(lastC);
        return ans;
    }
}