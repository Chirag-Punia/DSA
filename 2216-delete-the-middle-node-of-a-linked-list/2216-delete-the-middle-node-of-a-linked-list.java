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

    public static ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        if (head == null || head.next == null) {
            return head;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        } else if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode prev = mid(head);
        prev.next = prev.next.next;
        return head;
    }
}