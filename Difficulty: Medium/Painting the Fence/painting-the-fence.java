class Solution {
    int countWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        
        int same = k;
        int diff = k * (k - 1);
        int total = same + diff;
        
        for (int i = 3; i <= n; i++) {
            same = diff;
            
            diff = total * (k - 1);
            
            total = same + diff;
        }
        
        return total;
    }
}