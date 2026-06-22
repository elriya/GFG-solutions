import java.util.List;

class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Number of bars strictly between left and right indices
            int width = right - left - 1; 
            
            // Width must be greater than 0 to form a valid area
            if (width > 0) {
                int currentHeight = Math.min(height.get(left), height.get(right));
                int currentArea = currentHeight * width;
                maxArea = Math.max(maxArea, currentArea);
            }
            
            // Move the pointer pointing to the shorter bar
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}