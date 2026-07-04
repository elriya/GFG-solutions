class Solution {
    public int countSubstring(String s) {
        int n = s.length();
        
        // The minimum possible prefix sum is -n, maximum is n. 
        // We shift everything by +n to keep indices positive (0 to 2n).
        int[] freq = new int[2 * n + 1];
        
        int currentSum = 0;
        int validSubstrings = 0;
        
        // Base case
        freq[0 + n]++; 
        
        // Tracks how many prefix sums encountered so far are strictly less than the currentSum
        int strictlyLessCount = 0; 
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // Moving up
                strictlyLessCount += freq[currentSum + n];
                currentSum++;
            } else {
                // Moving down
                currentSum--;
                strictlyLessCount -= freq[currentSum + n];
            }
            
            validSubstrings += strictlyLessCount;
            freq[currentSum + n]++;
        }
        
        return validSubstrings;
    }
}