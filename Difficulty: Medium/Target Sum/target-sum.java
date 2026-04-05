class Solution {
    public int totalWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;
        
        if (subsetSum < 0) return 0;

        return countSubsets(arr, subsetSum);
    }

    private int countSubsets(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; 

        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}