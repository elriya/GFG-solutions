import java.util.ArrayList;

class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        long MOD = 1000000007;

        if (n == 1) {
            return arr[0];
        }

        int countPos = 0;
        int countNeg = 0;
        int countZero = 0;
        int maxNeg = Integer.MIN_VALUE; 
        long product = 1;
        boolean taken = false; 
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }
            if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            } else {
                countPos++;
            }
            
            product = (product * Math.abs(arr[i])) % MOD;
            taken = true;
        }

        if (countNeg % 2 != 0) {
            if (countNeg == 1 && countPos == 0 && countZero > 0) {
                return 0;
            }
            
            product = 1;
            taken = false;
            int skippedNeg = 0;
            
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                if (arr[i] == maxNeg && skippedNeg == 0) {
                    skippedNeg++; 
                    continue;
                }
                product = (product * Math.abs(arr[i])) % MOD;
                taken = true;
            }
        }

        if (!taken) {
            return 0;
        }

        return (int) product;
    }
}