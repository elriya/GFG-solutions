class Solution {
    public int visibleBuildings(int[] arr) {
        int visibleCount = 0;
        int maxHeight = -1; 
        
        for (int height : arr) {
            if (height >= maxHeight) {
                visibleCount++;
                maxHeight = height; 
            }
        }
        
        return visibleCount;
    }
}