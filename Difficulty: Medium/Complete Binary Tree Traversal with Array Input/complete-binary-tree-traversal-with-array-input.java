import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<ArrayList<Integer>>> result = new ArrayList<>(); // Outer container
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int n = arr.length;
        int index = 0;
        int levelSize = 1; // Level 0 starts with 1 node

        while (index < n) {
            ArrayList<Integer> currentLevel = new ArrayList<>();
            
            // Extract elements for the current level
            int count = 0;
            while (index < n && count < levelSize) {
                currentLevel.add(arr[index]);
                index++;
                count++;
            }
            
            // Sort the current level independently
            Collections.sort(currentLevel);
            
            res.add(currentLevel);
            
            // Next level can hold twice as many nodes
            levelSize *= 2;
        }

        return res;
    }
}