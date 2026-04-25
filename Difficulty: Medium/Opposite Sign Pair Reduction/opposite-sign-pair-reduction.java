import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int val : arr) {
            boolean pushed = true;

            while (!stack.isEmpty() && (long) stack.peek() * val < 0) {
                int top = stack.peek();
                int absTop = Math.abs(top);
                int absVal = Math.abs(val);

                if (absTop > absVal) {
                    pushed = false;
                    break; 
                } else if (absTop < absVal) {
                    stack.pop();
                } else {
                    stack.pop();
                    pushed = false;
                    break;
                }
            }

            if (pushed) {
                stack.push(val);
            }
        }

        ArrayList<Integer> result = new ArrayList<>(stack);
        Collections.reverse(result);
        return result;
    }
}