class Solution {
    public boolean canSplit(int[] arr) {
        long totalSum = 0;
        
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;
        long currentSum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];
            
            if (currentSum == target) {
                return true;
            }
        }

        return false;
    }
}