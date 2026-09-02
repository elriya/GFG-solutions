class Solution {
    public int solve(int n, String s) {
        int[] state = new int[26];

        int occupied = 0;
        int rejectedCount = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'A';

            if (state[idx] == 0) {
                if (occupied < n) {
                    occupied++;
                    state[idx] = 1;
                } else {
                    state[idx] = 2; 
                    rejectedCount++;
                }
            } 
            else if (state[idx] == 1) {
                occupied--;
            }
        }

        return rejectedCount;
    }
}