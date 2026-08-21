class Solution {
    int transform(String s1, String s2) {
        // If lengths differ, transformation is impossible
        if (s1.length() != s2.length()) {
            return -1;
        }

        // Array to count frequencies of characters
        int[] count = new int[256];
        int n = s1.length();

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        // If the strings don't contain the exact same characters, return -1
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return -1;
            }
        }

        int res = 0;
        int i = n - 1; // Pointer for s1
        int j = n - 1; // Pointer for s2

        // Traverse strings from end to beginning
        while (i >= 0) {
            // If characters match, move both pointers
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                // If they don't match, this character from s1 must be moved to the front
                res++;
                i--;
            }
        }

        return res;
    }
}