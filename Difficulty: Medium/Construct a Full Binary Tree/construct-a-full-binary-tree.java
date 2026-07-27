import java.util.HashMap;
import java.util.Map;

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> mirrorMap = new HashMap<>();

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        mirrorMap.clear();

        // Store preMirror indices for O(1) lookups
        for (int i = 0; i < preMirror.length; i++) {
            mirrorMap.put(preMirror[i], i);
        }

        return buildTree(pre, 0, pre.length - 1);
    }

    private Node buildTree(int[] pre, int mirrorStart, int mirrorEnd) {
        if (preIndex >= pre.length || mirrorStart > mirrorEnd) {
            return null;
        }

        // Root is always the next element in pre[]
        Node root = new Node(pre[preIndex++]);

        // Base case: leaf node reached
        if (mirrorStart == mirrorEnd || preIndex >= pre.length) {
            return root;
        }

        // Find the boundary between left and right subtrees in preMirror[]
        int leftChildVal = pre[preIndex];
        int mirrorIndex = mirrorMap.get(leftChildVal);

        // Recursively build left and right subtrees
        root.left = buildTree(pre, mirrorIndex, mirrorEnd);
        root.right = buildTree(pre, mirrorStart + 1, mirrorIndex - 1);

        return root;
    }
}