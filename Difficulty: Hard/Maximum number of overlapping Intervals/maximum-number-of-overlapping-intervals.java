import java.util.Arrays;

class Solution {
    public static int overlapInt(int[][] arr) {
        int n = arr.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i][0];
            ends[i] = arr[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxOverlap = 0;
        int currentOverlap = 0;
        int i = 0; 
        int j = 0;

        while (i < n) {
            if (starts[i] <= ends[j]) {
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            } else {
                currentOverlap--;
                j++;
            }
        }

        return maxOverlap;
    }
}