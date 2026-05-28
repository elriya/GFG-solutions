import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

/* Structure of binary tree node
class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        calculateVerticalSum(root, 0, map);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
    
    private void calculateVerticalSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        calculateVerticalSum(node.left, hd - 1, map);
        
        calculateVerticalSum(node.right, hd + 1, map);
    }
}