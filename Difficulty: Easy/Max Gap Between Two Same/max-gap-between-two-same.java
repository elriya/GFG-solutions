import java.util.Arrays;

class Solution {
    public int maxCharGap(String s) {
        int maxGap = -1;
        
        // Array to store the first occurrence index of each character ('a' to 'z')
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int charIdx = s.charAt(i) - 'a';
            
            if (firstIndex[charIdx] == -1) {
                // If it's the first time seeing this character, record its index
                firstIndex[charIdx] = i;
            } else {
                // If we've seen it before, calculate the gap and update the maximum
                int currentGap = i - firstIndex[charIdx] - 1;
                maxGap = Math.max(maxGap, currentGap);
            }
        }
        
        return maxGap;
    }
}