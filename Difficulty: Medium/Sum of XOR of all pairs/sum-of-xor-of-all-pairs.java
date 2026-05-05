class Solution {
    public long sumXOR(int[] arr) {
        long totalSum = 0;
        int n = arr.length;

        for (int i = 0; i < 31; i++) {
            long countOne = 0;
            long countZero = 0;

            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    countOne++;
                } else {
                    countZero++;
                }
            }

            totalSum += (countOne * countZero) * (1L << i);
        }

        return totalSum;
    }
}