import java.util.*;

class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int s = 0; s <= 2 * (n - 1); s++) {
            
            int startRow = Math.max(0, s - (n - 1));
            
            int endRow = Math.min(n - 1, s);
            
            for (int i = startRow; i <= endRow; i++) {
                int j = s - i;
                result.add(mat[i][j]);
            }
        }
        
        return result;
    }
}