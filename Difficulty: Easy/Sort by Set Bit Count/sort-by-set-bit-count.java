import java.util.*;

class Solution {
    public ArrayList<Integer> sortBySetBitCount(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            return Integer.compare(countB, countA); 
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int val : temp) {
            result.add(val);
        }
        
        return result;
    }
}