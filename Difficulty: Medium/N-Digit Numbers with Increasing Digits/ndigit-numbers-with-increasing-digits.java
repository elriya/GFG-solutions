import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base edge case for n = 1
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        
        if (n > 9) {
            return result;
        }
        
        backtrack(n, 0, 0, result);
        return result;
    }
    
    private static void backtrack(int n, int currentNum, int lastDigit, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(currentNum);
            return;
        }
        
        // The next digit must be strictly greater than the lastDigit
        for (int i = lastDigit + 1; i <= 9; i++) {
            backtrack(n - 1, currentNum * 10 + i, i, result);
        }
    }
}