import java.util.ArrayList;

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null;
        Node successor = null;
        Node curr = root;

        // Find Successor: Smallest value > key
        curr = root;
        while (curr != null) {
            if (curr.data > key) {
                successor = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // Find Predecessor: Largest value < key
        curr = root;
        while (curr != null) {
            if (curr.data < key) {
                predecessor = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }
}