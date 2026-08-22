/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public int numberOfTurns(Node root, int p, int q) {
        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        // Get the path strings for both p and q from the root
        findPath(root, p, new StringBuilder(), pathP);
        findPath(root, q, new StringBuilder(), pathQ);

        // Find where the paths diverge (which establishes the Lowest Common Ancestor)
        int i = 0;
        while (i < pathP.length() && i < pathQ.length() && pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }

        // Extract paths strictly starting from the LCA down to the nodes
        StringBuilder lcaToP = new StringBuilder(pathP.substring(i));
        StringBuilder lcaToQ = new StringBuilder(pathQ.substring(i));

        // Assemble the full traversal from p up to LCA, and LCA down to q
        // Notice we reverse the left-hand path because we are traveling upward.
        String fullPath = lcaToP.reverse().toString() + lcaToQ.toString();

        // Edge case: if they share the exact same node (or path is empty)
        if (fullPath.length() == 0) return -1;

        // Count the turns
        int turns = 0;
        for (int j = 0; j < fullPath.length() - 1; j++) {
            if (fullPath.charAt(j) != fullPath.charAt(j + 1)) {
                turns++;
            }
        }

        // If it takes 0 turns, it is a direct line -> return -1
        return turns == 0 ? -1 : turns;
    }

    // Helper function to find a target node and record its directional string path
    private boolean findPath(Node node, int target, StringBuilder currentPath, StringBuilder result) {
        if (node == null) return false;

        if (node.data == target) {
            result.append(currentPath);
            return true;
        }

        // Traverse Left
        currentPath.append('L');
        if (findPath(node.left, target, currentPath, result)) return true;
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        // Traverse Right
        currentPath.append('R');
        if (findPath(node.right, target, currentPath, result)) return true;
        currentPath.deleteCharAt(currentPath.length() - 1); // Backtrack

        return false;
    }
}