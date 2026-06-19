class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) {
            return 1;
        }
        
        if (a.equals("0")) {
            return 0;
        }
        
        int lastDigitOfA = a.charAt(a.length() - 1) - '0';
        
        int expMod4 = 0;
        for (int i = 0; i < b.length(); i++) {
            expMod4 = (expMod4 * 10 + (b.charAt(i) - '0')) % 4;
        }
        
        if (expMod4 == 0) {
            expMod4 = 4;
        }
        
        int result = (int) Math.pow(lastDigitOfA, expMod4);
        
        return result % 10;
    }
}