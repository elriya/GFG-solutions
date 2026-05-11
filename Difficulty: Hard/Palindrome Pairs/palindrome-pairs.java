import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean palindromePair(String[] arr) {
        int n = arr.length;
        if (n < 2) return false;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            String word = arr[i];
            int len = word.length();

            for (int k = 0; k <= len; k++) {
                String prefix = word.substring(0, k);
                String suffix = word.substring(k);

                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(reversedSuffix) && map.get(reversedSuffix) != i) {
                        return true;
                    }
                }

                if (k < len && isPalindrome(suffix)) {
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(reversedPrefix) && map.get(reversedPrefix) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}