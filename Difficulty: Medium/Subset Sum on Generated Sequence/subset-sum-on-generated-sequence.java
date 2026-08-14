import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) return true;

        List<Long> paper = new ArrayList<>();
        long currentSum = s;
        paper.add((long) s);

        // Generate numbers on the paper up to x
        for (int val : arr) {
            if (currentSum > x) {
                break;
            }
            long nextVal = currentSum + val;
            paper.add(nextVal);
            currentSum += nextVal;
        }

        // Greedy subset sum from the largest element down to the smallest
        long target = x;
        for (int i = paper.size() - 1; i >= 0; i--) {
            long num = paper.get(i);
            if (num <= target) {
                target -= num;
            }
        }

        return target == 0;
    }
}