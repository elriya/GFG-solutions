import java.util.Arrays;

class Solution {
    public long maxProduct(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        long maxProd = Long.MIN_VALUE;

        int negCount = 0;
        while (negCount < n && arr[negCount] < 0) {
            negCount++;
        }
        int nonNegCount = n - negCount;

        int startC = Math.max(0, k - nonNegCount);
        int endC = Math.min(k, negCount);

        boolean foundValid = false;

        for (int c = startC; c <= endC; c++) {
            int nonNegNeeded = k - c;
            if (nonNegNeeded < 0 || nonNegNeeded > nonNegCount) continue;

            long prod = 1;

            if (c > 0) {
                if (c % 2 == 0) {
                    for (int i = 0; i < c; i++) {
                        prod *= arr[i];
                    }
                } else {
                    for (int i = negCount - c; i < negCount; i++) {
                        prod *= arr[i];
                    }
                }
            }

            for (int i = 0; i < nonNegNeeded; i++) {
                prod *= arr[n - 1 - i];
            }

            if (!foundValid || prod > maxProd) {
                maxProd = prod;
                foundValid = true;
            }
        }

        return maxProd;
    }
}