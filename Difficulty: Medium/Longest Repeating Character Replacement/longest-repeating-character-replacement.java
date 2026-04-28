class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] charCounts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            charCounts[s.charAt(right) - 'A']++;
            
            maxFreq = Math.max(maxFreq, charCounts[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k) {
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}