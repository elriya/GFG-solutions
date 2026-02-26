class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);

            if (m1[char1] != m2[char2]) {
                return false;
            }

            m1[char1] = i + 1;
            m2[char2] = i + 1;
        }

        return true;
    }
}