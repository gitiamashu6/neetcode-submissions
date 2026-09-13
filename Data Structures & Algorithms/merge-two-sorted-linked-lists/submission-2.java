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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp = null;
        if(list1 == null) return list2;
        if(list2 == null) return list1; 
        while(list1 != null && list2 != null) {
            ListNode node = new ListNode();
            if(list1.val <= list2.val) {
                node.val = list1.val;
                list1 = list1.next;
            }
            else {
                node.val = list2.val;
                list2 = list2.next;
            }
            if(head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = node;
            }

        }
        if(list1 == null) temp.next = list2;
        if(list2 == null) temp.next = list1;
        return head;
    }
}