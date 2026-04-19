class Solution {
    public boolean isPower(int x, int y) {
        if (y == 1) {
            return true;
        }
        
        if (x == 1) {
            return false;
        }
        
        while (y > 1) {
            if (y % x != 0) {
                return false; 
            }
            y /= x;
        }
        
        return y == 1;
    }
}