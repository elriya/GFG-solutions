import java.util.*;

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentSegments, ArrayList<String> result) {
        if (currentSegments.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", currentSegments));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String part = s.substring(start, start + len);
            
            if ((part.length() > 1 && part.startsWith("0")) || Integer.parseInt(part) > 255) {
                continue;
            }

            currentSegments.add(part);
            backtrack(s, start + len, currentSegments, result);
            currentSegments.remove(currentSegments.size() - 1);
        }
    }
}