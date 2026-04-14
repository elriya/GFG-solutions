class Solution {
    String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                result.append(current);
            }
        }
        
        return result.toString();
    }
}