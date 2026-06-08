/* Structure of linked list node
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = reverse(head);

        Node current = head;
        Node maxNode = head;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }

        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}