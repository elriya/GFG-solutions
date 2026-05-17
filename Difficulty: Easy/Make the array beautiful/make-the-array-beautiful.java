import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static List<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        
        for (int num : arr) {
            if (st.isEmpty()) {
                st.push(num);
            } else {
                if ((st.peek() >= 0 && num < 0) || (st.peek() < 0 && num >= 0)) {
                    st.pop(); 
                } else {
                    st.push(num); 
                }
            }
        }
        
        return new ArrayList<>(st);
    }
}