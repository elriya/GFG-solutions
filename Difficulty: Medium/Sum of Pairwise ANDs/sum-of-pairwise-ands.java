class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;

        for (int i = 0; i < 32; i++) {
            long count = 0;
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            // number of pairs that share this set bit
            long pairs = (count * (count - 1)) / 2;

            // contribution of this bit into total sum
            totalSum += pairs * (1L << i);
        }

        return totalSum;
    }
}