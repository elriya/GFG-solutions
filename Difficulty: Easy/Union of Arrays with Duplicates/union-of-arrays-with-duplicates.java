import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> unionSet = new HashSet<>();
        
        for (int num : a) {
            unionSet.add(num);
        }
        
        for (int num : b) {
            unionSet.add(num);
        }
        
        return new ArrayList<>(unionSet);
    }
}