class Solution {
    public int countIncreasing(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        int count = 0;
        int len = 1; 

        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                len++;
            } else {
                if (len >= 2) {
                    count += (len * (len - 1)) / 2;
                }
                len = 1; 
            }
        }

        if (len >= 2) {
            count += (len * (len - 1)) / 2;
        }

        return count;
    }
}