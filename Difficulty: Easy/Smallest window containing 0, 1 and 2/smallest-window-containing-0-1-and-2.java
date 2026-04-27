class Solution {
    public int smallestSubstring(String s) {
        int last0 = -1;
        int last1 = -1;
        int last2 = -1;
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '0') last0 = i;
            else if (c == '1') last1 = i;
            else if (c == '2') last2 = i;
            
            if (last0 != -1 && last1 != -1 && last2 != -1) {
                int start = Math.min(last0, Math.min(last1, last2));
                
                minLen = Math.min(minLen, i - start + 1);
            }
        }
        
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}