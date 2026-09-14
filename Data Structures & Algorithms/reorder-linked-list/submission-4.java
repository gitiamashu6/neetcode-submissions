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
    public void reorderList(ListNode head) {
        ListNode temp = head;
        ListNode c = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        int len = 0;
        while (c != null) {
            len++;
            c = c.next;
        }
        int k = (int) Math.floor(len / 2) -1;
        c = head;
        while (c != null) {
            if (k > 0) k--;
            else stack.push(c);
            c = c.next;
        }
        while (!stack.isEmpty()) {
            ListNode next  = temp.next;
            temp.next = stack.pop();
            if (temp == temp.next) break;
            else temp.next.next = next;
            temp = next;
        }
        temp.next = null;
    }
}

