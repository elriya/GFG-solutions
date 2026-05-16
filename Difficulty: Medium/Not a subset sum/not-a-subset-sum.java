import java.util.Arrays;

class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        
        int res = 1; 
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > res) {
                break;
            }
            
            res += arr[i];
        }
        
        return res;
    }
}