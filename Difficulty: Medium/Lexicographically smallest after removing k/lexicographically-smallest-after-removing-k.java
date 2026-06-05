class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();

        // Correct k
        if ((n & (n - 1)) == 0) { // power of 2
            k /= 2;
        } else {
            k *= 2;
        }

        if (k > n || n - k <= 0) {
            return "-1";
        }

        int keep = n - k;
        int remove = k;

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (remove > 0 &&
                   stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                remove--;
            }
            stack.append(ch);
        }

        // Remove remaining characters from the end
        while (remove > 0) {
            stack.deleteCharAt(stack.length() - 1);
            remove--;
        }

        return stack.substring(0, keep);
    }
}