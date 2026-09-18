/* The Node structure is defined as
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Node prev = null;

    public int absDiff(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrder(root);
        return minDiff;
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev.data);
        }
        prev = root;

        inOrder(root.right);
    }
}