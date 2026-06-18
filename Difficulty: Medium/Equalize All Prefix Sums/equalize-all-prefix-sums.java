import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int currentOperations = 0;
        
        result.add(0);
        
        for (int i = 1; i < n; i++) {
            currentOperations += (arr[i] - arr[i / 2]);
            result.add(currentOperations);
        }
        
        return result;
    }
}