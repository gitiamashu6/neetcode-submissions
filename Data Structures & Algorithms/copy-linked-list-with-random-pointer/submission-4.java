/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node head2 = null;
        Node temp2 = head2;
        while (temp != null) {
            Node node = new Node(temp.val);
            if (head2 == null) {
                head2 = node;
                temp2 = head2;
            } else {
                temp2.next = node;
                temp2 = node;
            }
            map.put(temp, node);
            temp = temp.next;
        }
        temp2 = head2;
        temp = head;
        while (temp2 != null && temp != null) {
            if (temp.random == null) {
                temp2.random = null;
            } else {
                temp2.random = map.get(temp.random);
            }
            temp2 = temp2.next;
            temp = temp.next;
        }
        return head2;
    }
}
