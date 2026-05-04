class Solution {
    public boolean isBinaryPalindrome(int n) {
        if (n == 0) return true;

        int left = 0;
        int temp = n;
        while (temp > 0) {
            temp >>= 1;
            left++;
        }
        
        left = left - 1; 
        int right = 0;

        while (left > right) {
            int leftBit = (n >> left) & 1;
            int rightBit = (n >> right) & 1;

            if (leftBit != rightBit) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }
}