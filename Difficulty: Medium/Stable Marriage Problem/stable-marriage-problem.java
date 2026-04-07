import java.util.*;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        
        int[][] womanRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int rank = 0; rank < n; rank++) {
                int m = women[w][rank];
                womanRank[w][m] = rank;
            }
        }

        int[] manToWoman = new int[n];   
        int[] womanToMan = new int[n];   
        int[] nextProposal = new int[n]; 
        
        Arrays.fill(manToWoman, -1);
        Arrays.fill(womanToMan, -1);
        
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            
            int w = men[m][nextProposal[m]++];
            
            if (womanToMan[w] == -1) {
                womanToMan[w] = m;
                manToWoman[m] = w;
            } 
            else {
                int currentM = womanToMan[w];
                
                if (womanRank[w][m] < womanRank[w][currentM]) {
                    womanToMan[w] = m;
                    manToWoman[m] = w;
                    
                    manToWoman[currentM] = -1;
                    freeMen.add(currentM);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return manToWoman;
    }
}