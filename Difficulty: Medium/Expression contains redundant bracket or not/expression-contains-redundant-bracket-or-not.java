import java.util.Stack;

class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ')') {
                char top = stack.peek();
                boolean hasOperator = false;
                
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char popped = stack.pop();
                    if (popped == '+' || popped == '-' || popped == '*' || popped == '/') {
                        hasOperator = true;
                    }
                }
                
                stack.pop();
                
                if (!hasOperator) {
                    return true;
                }
            } else {
                stack.push(ch);
            }
        }
        
        return false;
    }
}