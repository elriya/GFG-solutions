import java.util.Stack;

class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] leftCount = new int[n];
        int[] rightCount = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftCount[i] = i;
            } else {
                leftCount[i] = i - stack.peek() - 1;
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightCount[i] = (n - 1) - i;
            } else {
                rightCount[i] = stack.peek() - i - 1;
            }
            stack.push(i);
        }

        int maxSeen = 0;
        for (int i = 0; i < n; i++) {
            maxSeen = Math.max(maxSeen, leftCount[i] + rightCount[i] + 1);
        }

        return maxSeen;
    }
}