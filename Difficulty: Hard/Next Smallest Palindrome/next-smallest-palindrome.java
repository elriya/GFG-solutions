class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        
        if (isAll9s(num)) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        return findNext(num, n);
    }

    private static boolean isAll9s(int[] num) {
        for (int x : num) if (x != 9) return false;
        return true;
    }

    private static int[] findNext(int[] num, int n) {
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        boolean leftSmaller = false;
        if (i < 0 || num[i] < num[j]) {
            leftSmaller = true;
        }

        int[] res = num.clone();
        i = mid - 1;
        j = (n % 2 == 0) ? mid : mid + 1;
        
        while (i >= 0) {
            res[j] = res[i];
            i--;
            j++;
        }

        if (leftSmaller) {
            int carry = 1;
            i = (n % 2 == 0) ? mid - 1 : mid;
            
            while (i >= 0 && carry > 0) {
                res[i] += carry;
                carry = res[i] / 10;
                res[i] %= 10;
                
                res[n - 1 - i] = res[i];
                i--;
            }
        }

        return res;
    }
}