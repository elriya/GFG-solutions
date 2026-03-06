class Solution {
    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        int[] pCount = new int[256];
        int[] sCount = new int[256];

        for (char c : p.toCharArray()) {
            pCount[c]++;
        }

        int left = 0, right = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0; 

        while (right < s.length()) {
            char rChar = s.charAt(right);
            sCount[rChar]++;

            if (pCount[rChar] != 0 && sCount[rChar] <= pCount[rChar]) {
                count++;
            }

            while (count == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                sCount[lChar]--;
                
                if (pCount[lChar] != 0 && sCount[lChar] < pCount[lChar]) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}