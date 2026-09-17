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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null, temp = head, node;
        int c = 0, r =0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                r = (l2.val + c) % 10;
                c = (l2.val + c) / 10;
                node = new ListNode(r);
                l2 = l2.next;
            } else if (l2 == null) {
                r = (l1.val + c) % 10;
                c = (l1.val + c) / 10;
                node = new ListNode(r);
                l1 = l1.next;
            } else {
                r = (l1.val + l2.val + c) % 10;
                c = (l1.val + l2.val + c) / 10;
                node = new ListNode(r);
                l1 = l1.next;
                l2 = l2.next;
            }
            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = node;
            }
        }
        if (c > 0) {
            node = new ListNode(c);
            temp.next = node;
            temp = node;
        }
        return head;
    }
}
