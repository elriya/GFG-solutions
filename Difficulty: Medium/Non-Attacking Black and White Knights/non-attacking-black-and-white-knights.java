class Solution {
    public int numOfWays(int n, int m) {
        long totalSquares = (long) n * m;
        
        long totalWays = totalSquares * (totalSquares - 1);
        
        long box2x3 = 0;
        long box3x2 = 0;
        
        if (n >= 2 && m >= 3) {
            box2x3 = (long) (n - 1) * (m - 2);
        }
        if (n >= 3 && m >= 1) { 
            box3x2 = (long) (n - 2) * (m - 1);
        }
        
        long attackingWays = 4 * (box2x3 + box3x2);
        
        return (int) (totalWays - attackingWays);
    }
}