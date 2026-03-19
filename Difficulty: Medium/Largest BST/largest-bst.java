/* The Node class is already defined by the platform:
  class Node {
      int data;
      Node left, right;
      Node(int d) {
          data = d;
          left = right = null;
      }
  }
*/

class Info {
    boolean isBST;
    int size;
    int min;
    int max;

    Info(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    static int maxBSTSize;

    static int largestBst(Node root) {
        maxBSTSize = 0;
        solve(root);
        return maxBSTSize;
    }

    static Info solve(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int currentSize = left.size + right.size + 1;
            maxBSTSize = Math.max(maxBSTSize, currentSize);
            
            return new Info(
                true, 
                currentSize, 
                Math.min(root.data, left.min), 
                Math.max(root.data, right.max)
            );
        }

        return new Info(false, 0, 0, 0);
    }
}