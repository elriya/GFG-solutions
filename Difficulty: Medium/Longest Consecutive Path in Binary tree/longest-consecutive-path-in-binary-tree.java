class Solution {
    private int maxLen = 1;

    public int longestConsecutive(Node root) {
        if (root == null) {
            return -1;
        }

        // Start DFS traversal
        // Pass root.data - 1 as initial dummy parent data so the root gets a length of 1
        dfs(root, root.data - 1, 0);

        // If maximum path length is 1, it means no consecutive parent-child pair existed
        return maxLen > 1 ? maxLen : -1;
    }

    private void dfs(Node node, int parentData, int currentLen) {
        if (node == null) {
            return;
        }

        // If the current node value is strictly 1 greater than its parent's value
        if (node.data == parentData + 1) {
            currentLen++;
        } else {
            // Reset consecutive length to 1 starting from this node
            currentLen = 1;
        }

        // Update global maximum
        maxLen = Math.max(maxLen, currentLen);

        // Recur for left and right subtrees
        dfs(node.left, node.data, currentLen);
        dfs(node.right, node.data, currentLen);
    }
}