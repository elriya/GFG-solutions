import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int runningXor = 0;
        result.add(0);
        
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            
            if (type == 0) {
                result.add(x ^ runningXor);
            } else if (type == 1) {
                runningXor ^= x;
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) ^ runningXor);
        }
        
        Collections.sort(result);
        
        return result;
    }
}