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

    public static ListNode reverse(ListNode current,ListNode prev){
        if(current == null){
            return prev;
        }
        ListNode next = current.next;
        current.next = prev;
        return reverse(next,current);
    }
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        return reverse(head,null);
    }
}