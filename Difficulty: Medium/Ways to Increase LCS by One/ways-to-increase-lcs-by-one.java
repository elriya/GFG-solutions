import java.util.*;

class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        // Precompute Prefix LCS
        int[][] lcsFront = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcsFront[i][j] = lcsFront[i - 1][j - 1] + 1;
                } else {
                    lcsFront[i][j] = Math.max(lcsFront[i - 1][j], lcsFront[i][j - 1]);
                }
            }
        }
        
        int originalLCS = lcsFront[n1][n2];
        
        // Precompute Suffix LCS
        int[][] lcsBack = new int[n1 + 1][n2 + 1];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lcsBack[i][j] = lcsBack[i + 1][j + 1] + 1;
                } else {
                    lcsBack[i][j] = Math.max(lcsBack[i + 1][j], lcsBack[i][j + 1]);
                }
            }
        }
        
        int ways = 0;
        
        // Evaluate each position and each character
        for (int i = 0; i <= n1; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                boolean validInsertion = false;
                
                for (int j = 0; j < n2; j++) {
                    // If the character matches s2[j], check if it yields a larger LCS
                    if (s2.charAt(j) == ch) {
                        if (lcsFront[i][j] + 1 + lcsBack[i][j + 1] == originalLCS + 1) {
                            validInsertion = true;
                            break; // One valid match at index j is enough for this character at position i
                        }
                    }
                }
                
                if (validInsertion) {
                    ways++;
                }
            }
        }
        
        return ways;
    }
}