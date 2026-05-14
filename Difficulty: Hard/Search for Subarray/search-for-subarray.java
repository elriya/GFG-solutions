import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        if (m == 0) return result;

        int[] lps = computeLPS(b);

        int i = 0; 
        int j = 0; 

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && a[i] != b[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPS(int[] b) {
        int m = b.length;
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}