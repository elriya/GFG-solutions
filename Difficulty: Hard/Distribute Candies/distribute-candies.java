class Solution {
    int totalMoves = 0;

    public int distCandy(Node root) {
        totalMoves = 0;
        calculateBalance(root);
        return totalMoves;
    }

    private int calculateBalance(Node node) {
        if (node == null) {
            return 0;
        }

        int leftBalance = calculateBalance(node.left);
        int rightBalance = calculateBalance(node.right);

        totalMoves += Math.abs(leftBalance) + Math.abs(rightBalance);

        return node.data - 1 + leftBalance + rightBalance;
    }
}