import java.util.*;

class Solution {
    public int catchThieves(char[] arr, int k) {
        int result = 0;
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else {
                thieves.add(i);
            }
        }

        int p = 0, t = 0;
        while (p < police.size() && t < thieves.size()) {
            if (Math.abs(police.get(p) - thieves.get(t)) <= k) {
                result++;
                p++;
                t++;
            } 
            else if (thieves.get(t) < police.get(p)) {
                t++;
            } 
            else {
                p++;
            }
        }

        return result;
    }
}