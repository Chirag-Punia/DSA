/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode current = head.next;
            ListNode prev = head;
            ListNode temp = head;
            while (temp != null) {
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
            head.next = null;
            head = prev;
        }

        return head;
    }
}