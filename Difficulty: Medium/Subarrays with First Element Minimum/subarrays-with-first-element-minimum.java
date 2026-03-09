import java.util.Stack;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            totalCount += (nextSmaller[i] - i);
        }
        
        return totalCount;
    }
}