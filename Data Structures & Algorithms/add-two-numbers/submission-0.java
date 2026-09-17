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
        ListNode head = null, temp = head, t1 = l1, t2 = l2;
        int c = 0;
        int r = 0;
        while (t1 != null || t2 != null) {
            ListNode node;
            if (t1 == null) {
                r = (t2.val + c) % 10;
                c = (t2.val + c) / 10;
                node = new ListNode(r);
                t2 = t2.next;
            } else if (t2 == null) {
                r = (t1.val + c) % 10;
                c = (t1.val + c) / 10;
                node = new ListNode(r);
                t1 = t1.next;
            } else {
                r = (t1.val + t2.val + c) % 10;
                c = (t1.val + t2.val + c) / 10;
                node = new ListNode(r);
                t1 = t1.next;
                t2 = t2.next;
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
            ListNode node = new ListNode(c);
            temp.next = node;
            temp = node;
        }
        return head;
        // while (t1 != null) {
        //     if (t2 == null) {
        //         ListNode node = new ListNode(t1.val + c);
        //         t1
        //     }
        // }
    }
}
