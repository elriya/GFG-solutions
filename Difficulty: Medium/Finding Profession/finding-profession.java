class Solution {
    public String profession(int level, int pos) {
        int setBits = Integer.bitCount(pos - 1);
        
        if (setBits % 2 == 0) {
            return "Engineer";
        } else {
            return "Doctor";
        }
    }
}