/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    public void toSumTree(Node root) {
        transform(root);
    }
    
    private int transform(Node node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = transform(node.left);
        int rightSum = transform(node.right);
        
        int originalValue = node.data;
        
        node.data = leftSum + rightSum;
        
        return originalValue + node.data;
    }
}