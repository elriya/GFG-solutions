import java.util.Arrays;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int n = a.length;
        
        int minDiff = Integer.MAX_VALUE;
        long minSum = Long.MAX_VALUE;
        int[] result = new int[3];

        while (i < n && j < n && k < n) {
            int valA = a[i];
            int valB = b[j];
            int valC = c[k];

            int currentMax = Math.max(valA, Math.max(valB, valC));
            int currentMin = Math.min(valA, Math.min(valB, valC));
            int currentDiff = currentMax - currentMin;
            long currentSum = (long) valA + valB + valC;

            if (currentDiff < minDiff || (currentDiff == minDiff && currentSum < minSum)) {
                minDiff = currentDiff;
                minSum = currentSum;
                result[0] = valA;
                result[1] = valB;
                result[2] = valC;
            }

            if (valA == currentMin) {
                i++;
            } else if (valB == currentMin) {
                j++;
            } else {
                k++;
            }
        }

        Arrays.sort(result);
        return new int[]{result[2], result[1], result[0]};
    }
}