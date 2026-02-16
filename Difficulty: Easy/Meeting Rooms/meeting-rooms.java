import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i][1] > arr[i + 1][0]) {
                return false;
            }
        }

        return true;
    }
}