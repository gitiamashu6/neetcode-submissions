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
        Map<Integer, Node> map = new HashMap<>();
        Map<Node, Node> map2 = new HashMap<>();

        Node temp = head;
        int i = 0;
        while (temp != null) {
            map.put(i, temp.random);
            temp = temp.next;
            i++;
        }
        temp = head;
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
            map2.put(temp, node);
            temp = temp.next;
        }
        temp2 = head2;
        temp = head;
        i = 0;
        while (temp2 != null && temp != null) {
            Node node = map.get(i);
            if (node == null) {
                temp2.random = null;
            } else {
                temp2.random = map2.get(node);
            }
            // System.out.println("Value->" + temp2.val + " i->" + i + " Random->" + map.get(i));
            i++;
            temp2 = temp2.next;
            temp = temp.next;
        }
        return head2;
    }
}
