import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        int lastAdded = Integer.MIN_VALUE; 
        
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                if (result.isEmpty() || a[i] != result.get(result.size() - 1)) {
                    result.add(a[i]);
                }
                i++;
                j++;
                k++;
            } 
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return result;
    }
}