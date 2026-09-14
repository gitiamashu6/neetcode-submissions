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
        while (c != null) {
            stack.push(c);
            c = c.next;
        }
        ListNode next = temp;
        int k = (int) Math.ceil((double)stack.size() / 2);
        System.out.println(k);
        while (k > 0) {
            next = temp.next;
            if (k == 1) {
                temp.next = stack.pop();
                temp.next.next = null;
            } else {
                temp.next = stack.pop();
                temp.next.next = next;
                temp = next;
            }

            k--;
        }
    }
}
