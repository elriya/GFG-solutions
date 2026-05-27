class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int needed = 0; 
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (i - x <= needed) {
                    needed = i + x + 1;
                } else {
                    return false;
                }
            }
        }
        
        return needed >= n;
    }
}