import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        Map<Long, Integer> leftSums = getSubsetSums(arr, 0, mid);
        Map<Long, Integer> rightSums = getSubsetSums(arr, mid, n);

        int totalCount = 0;

        for (Map.Entry<Long, Integer> entry : leftSums.entrySet()) {
            long s1 = entry.getKey();
            long complement = (long) k - s1;
            
            if (rightSums.containsKey(complement)) {
                totalCount += entry.getValue() * rightSums.get(complement);
            }
        }

        return totalCount;
    }

    private Map<Long, Integer> getSubsetSums(int[] arr, int start, int end) {
        Map<Long, Integer> map = new HashMap<>();
        int length = end - start;
        int numSubsets = 1 << length; 

        for (int i = 0; i < numSubsets; i++) {
            long currentSum = 0;
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSum += arr[start + j];
                }
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return map;
    }
}