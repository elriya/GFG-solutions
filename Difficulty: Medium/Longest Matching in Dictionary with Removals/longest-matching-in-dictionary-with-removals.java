import java.util.List;

class Solution {
    public String findLongestWord(String s, List<String> d) {
        int n = s.length();
        int[][] nextPos = new int[n + 1][26];

        for (int c = 0; c < 26; c++) {
            nextPos[n][c] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = nextPos[i + 1][c];
            }
            nextPos[i][s.charAt(i) - 'a'] = i;
        }

        String bestWord = "";

        for (String word : d) {
            int curr = 0;
            boolean isSubsequence = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (curr == -1 || nextPos[curr][c] == -1) {
                    isSubsequence = false;
                    break;
                }
                curr = nextPos[curr][c] + 1;
            }

            if (isSubsequence) {
                if (word.length() > bestWord.length()) {
                    bestWord = word;
                } else if (word.length() == bestWord.length()) {
                    if (word.compareTo(bestWord) < 0) {
                        bestWord = word;
                    }
                }
            }
        }

        return bestWord;
    }
}