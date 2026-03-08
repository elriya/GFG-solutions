class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        int maxVal = 0;
        for (int x : arr) {
            if (x > maxVal) maxVal = x;
        }

        boolean[] exists = new boolean[maxVal + 1];
        for (int x : arr) {
            exists[x] = true;
        }

        for (int i = 1; i <= maxVal; i++) {
            if (!exists[i]) continue;

            for (int j = i + 1; j <= maxVal; j++) {
                if (!exists[j]) continue;

                int val = (i * i) + (j * j);
                int c = (int) Math.sqrt(val);

                if (c * c == val && c <= maxVal && exists[c]) {
                    return true;
                }
            }
        }

        return false;
    }
}