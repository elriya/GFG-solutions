import java.util.HashMap;

class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        if (n <= 2) return n;

        HashMap<Integer, Integer> counts = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            counts.put(arr[right], counts.getOrDefault(arr[right], 0) + 1);

            while (counts.size() > 2) {
                int leftVal = arr[left];
                counts.put(leftVal, counts.get(leftVal) - 1);
                
                if (counts.get(leftVal) == 0) {
                    counts.remove(leftVal);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}