import java.util.*;

class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        int maxVal = 0;
        
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
        }
        
        int[] freq = new int[maxVal + 1];
        for (int num : arr) {
            freq[num]++;
        }
        
        Stack<Integer> stack = new Stack<>();
        Integer[] result = new Integer[n];
        
        for (int i = n - 1; i >= 0; i--) {
            int currentVal = arr[i];
            int currentFreq = freq[currentVal];
            
            while (!stack.isEmpty() && freq[stack.peek()] <= currentFreq) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            
            stack.push(currentVal);
        }
        
        return new ArrayList<>(Arrays.asList(result));
    }
}