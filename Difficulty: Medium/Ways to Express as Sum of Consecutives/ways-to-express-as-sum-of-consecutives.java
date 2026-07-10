class Solution {
    public int getCount(int n) {
        int count = 0;
        
        for (int k = 2; (k * (k - 1)) / 2 < n; k++) {
            int remainingSum = n - (k * (k - 1)) / 2;
            
            if (remainingSum % k == 0) {
                count++;
            }
        }
        
        return count;
    }
}