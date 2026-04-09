import java.util.ArrayList;

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0; 
        int j = 0; 
        
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
            }
        }
        
        return result;
    }
}