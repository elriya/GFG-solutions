import java.util.Stack;

class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        return (int) (sumSubarrayMax(arr) - sumSubarrayMin(arr));
    }

    private long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) s.pop();
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) s.pop();
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }
        return sum;
    }

    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) s.pop();
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i - left[i]) * (right[i] - i);
        }
        return sum;
    }
}