import java.util.*;

class Solution {
    public int minTime(Node root, int target) {
        //Map children to parents and find the target node
        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = findTargetAndMapParents(root, target, parentMap);
        
        //BFS to simulate the fire spreading
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.offer(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spreadHappened = false;
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Check Left Child
                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                    spreadHappened = true;
                }
                // Check Right Child
                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                    spreadHappened = true;
                }
                // Check Parent
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                    spreadHappened = true;
                }
            }
            
            if (spreadHappened) {
                time++;
            }
        }
        
        return time;
    }
    
    private Node findTargetAndMapParents(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetNode = null;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) targetNode = curr;
            
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
        return targetNode;
    }
}