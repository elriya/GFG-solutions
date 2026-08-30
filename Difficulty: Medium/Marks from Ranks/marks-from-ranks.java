import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        int[] prefix = new int[n];

        prefix[0] = r[0] - l[0] + 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (r[i] - l[i] + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int q : rank) {
            int low = 0, high = n - 1;
            int ansIndex = -1;

            // Binary search to find the correct interval for the current rank 'q'
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefix[mid] >= q) {
                    ansIndex = mid;
                    high = mid - 1;     // Try to find an earlier interval
                } else {
                    low = mid + 1;
                }
            }

            if (ansIndex == -1) {
                // If rank is completely out of bounds of our intervals (total number of marks)
                res.add(-1);
            } else {
                // Calculate the actual mark using the offset within the identified interval
                int prevCount = (ansIndex == 0) ? 0 : prefix[ansIndex - 1];
                int actualMark = l[ansIndex] + q - prevCount - 1;
                res.add(actualMark);
            }
        }

        return res;
    }
}