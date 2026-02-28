import java.util.*;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        
        int left = 0;
        int right = m - 1;
        
        int minDiff = Integer.MAX_VALUE;
        
        int res1 = -1, res2 = -1;
        
        while (left < n && right >= 0) {
            int currentSum = arr1[left] + arr2[right];
            int currentDiff = Math.abs(currentSum - x);
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                res1 = arr1[left];
                res2 = arr2[right];
            }
            
            if (currentSum > x) {
                right--;
            } 
            else if (currentSum < x) {
                left++;
            } 
            else {
                break;
            }
        }
        
        result.add(res1);
        result.add(res2);
        return result;
    }
}