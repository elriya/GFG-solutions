import java.util.Stack;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            nextSmaller[i] = n;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (nextSmaller[i] - i);
        }

        return (int) count;
    }
}