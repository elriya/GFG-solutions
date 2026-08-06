class Solution {
    public int countMinOperations(int arr[]) {
        int totalSetBits = 0;
        int maxVal = 0;

        for (int num : arr) {
            totalSetBits += Integer.bitCount(num);
            if (num > maxVal) {
                maxVal = num;
            }
        }

        // If the array is all zeros, zero operations are needed
        if (maxVal == 0) {
            return 0;
        }

        // Highest bit position zero-indexed: 31 - Integer.numberOfLeadingZeros(maxVal)
        int maxDoubles = 31 - Integer.numberOfLeadingZeros(maxVal);

        return totalSetBits + maxDoubles;
    }
}