class Solution {
    public int getCount(int n, int d) {
        int low = 1, high = n;
        int smallestK = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid - getSumOfDigits(mid) >= d) {
                smallestK = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }

        if (smallestK == -1) {
            return 0;
        }
        
        return n - smallestK + 1;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}