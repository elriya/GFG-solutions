class Solution {
    public int maxSubsetXOR(int[] arr) {
        int index = 0; // Tracks the position of the next basis element

        // Process bits from Most Significant Bit (20 covers up to 10^6) down to LSB
        for (int bit = 20; bit >= 0; bit--) {
            int maxIdx = index;
            int maxElement = -1;

            // Find an element with the `bit`-th bit set
            for (int i = index; i < arr.length; i++) {
                if ((arr[i] & (1 << bit)) != 0 && arr[i] > maxElement) {
                    maxElement = arr[i];
                    maxIdx = i;
                }
            }

            // If no element has this bit set, skip this bit position
            if (maxElement == -1) {
                continue;
            }

            // Swap the chosen element to the current index
            int temp = arr[index];
            arr[index] = arr[maxIdx];
            arr[maxIdx] = temp;

            // Reduce all other elements that have the `bit`-th bit set
            for (int i = 0; i < arr.length; i++) {
                if (i != index && (arr[i] & (1 << bit)) != 0) {
                    arr[i] ^= arr[index];
                }
            }

            index++;
        }

        // Maximizing the XOR output from reduced basis
        int maxXor = 0;
        for (int i = 0; i < arr.length; i++) {
            maxXor ^= arr[i];
        }

        return maxXor;
    }
}