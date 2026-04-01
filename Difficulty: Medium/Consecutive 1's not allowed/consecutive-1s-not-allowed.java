class Solution {
    int countStrings(int n) {
        if (n == 1) return 2;
        if (n == 2) return 3;

        int prev2 = 2; 
        int prev1 = 3; 
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}