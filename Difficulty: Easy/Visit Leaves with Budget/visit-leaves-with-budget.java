import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int getCount(Node root, int k) {
        List<Integer> leafLevels = new ArrayList<>();

        getLeafLevels(root, 1, leafLevels);

        Collections.sort(leafLevels);

        int count = 0;
        int currentCost = 0;

        for (int levelCost : leafLevels) {
            if (currentCost + levelCost <= k) {
                currentCost += levelCost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    private void getLeafLevels(Node node, int level, List<Integer> leafLevels) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafLevels.add(level);
            return;
        }

        getLeafLevels(node.left, level + 1, leafLevels);
        getLeafLevels(node.right, level + 1, leafLevels);
    }
}