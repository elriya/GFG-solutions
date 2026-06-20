import java.util.Arrays;

class Solution {
    public String chooseSwap(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int[] firstOccur = new int[26];
        Arrays.fill(firstOccur, -1);
        
        for (int i = 0; i < n; i++) {
            int charIdx = arr[i] - 'a';
            if (firstOccur[charIdx] == -1) {
                firstOccur[charIdx] = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int currentCtrl = arr[i] - 'a';
            boolean foundSwap = false;
            
            for (int j = 0; j < currentCtrl; j++) {
                if (firstOccur[j] > i) {
                    char c1 = arr[i];
                    char c2 = (char) (j + 'a');
                    
                    for (int k = 0; k < n; k++) {
                        if (arr[k] == c1) {
                            arr[k] = c2;
                        } else if (arr[k] == c2) {
                            arr[k] = c1;
                        }
                    }
                    foundSwap = true;
                    break;
                }
            }
            
            if (foundSwap) {
                break;
            }
        }
        
        return new String(arr);
    }
}