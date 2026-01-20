import java.util.Stack;

class Solution {
    private Stack<Character> docStack = new Stack<>();
    private Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        docStack.push(x);
        redoStack.clear();
    }

    public void undo() {
        if (!docStack.isEmpty()) {
            char removed = docStack.pop();
            redoStack.push(removed);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char restored = redoStack.pop();
            docStack.push(restored);
        }
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        for (Character c : docStack) {
            sb.append(c);
        }
        return sb.toString();
    }
}