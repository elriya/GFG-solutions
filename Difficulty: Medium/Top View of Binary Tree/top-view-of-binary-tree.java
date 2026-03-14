import java.util.*;

class Solution {
    class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }
}