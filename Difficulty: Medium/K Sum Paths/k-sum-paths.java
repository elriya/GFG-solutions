import java.util.HashMap;

class Solution {
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        
        map.put(0L, 1);
        
        return dfs(root, 0L, k, map);
    }

    private int dfs(Node node, long currentSum, int k, HashMap<Long, Integer> map) {
        if (node == null) {
            return 0;
        }

        currentSum += node.data;
        
        int count = map.getOrDefault(currentSum - k, 0);

        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, k, map);
        count += dfs(node.right, currentSum, k, map);

        map.put(currentSum, map.get(currentSum) - 1);

        return count;
    }
}