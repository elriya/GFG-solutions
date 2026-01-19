class Solution {
    public String removeKdig(String s, int k) {
        int n = s.length();
        if (k == n) return "0";

        StringBuilder stack = new StringBuilder();

        for (char digit : s.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        for (int i = 0; i < stack.length(); i++) {
            char c = stack.charAt(i);
            if (leadingZero && c == '0') continue;
            leadingZero = false;
            result.append(c);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}