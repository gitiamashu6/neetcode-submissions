/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;
        ListNode current = head;
        ListNode prev = head;
        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }
        int i = len - n + 1;
        current = head;
        while (i > 0) {
            if (i == 1) {
                if (current == head)
                    return current.next;
                prev.next = current.next;
                current.next = null;
                return head;
            }
            ListNode next = current.next;
            prev = current;
            current = next;
            i--;
        }
        return head;
    }
}
