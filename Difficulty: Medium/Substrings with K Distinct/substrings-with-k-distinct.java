class Solution {
    public long countSubstr(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }

    private long atMost(String s, int k) {
        if (k < 0) return 0;
        
        int n = s.length();
        long count = 0;
        int left = 0;
        int distinctCount = 0;
        int[] freq = new int[26];

        for (int right = 0; right < n; right++) {
            if (freq[s.charAt(right) - 'a'] == 0) {
                distinctCount++;
            }
            freq[s.charAt(right) - 'a']++;

            while (distinctCount > k) {
                freq[s.charAt(left) - 'a']--;
                if (freq[s.charAt(left) - 'a'] == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += (right - left + 1);
        }
        return count;
    }
}