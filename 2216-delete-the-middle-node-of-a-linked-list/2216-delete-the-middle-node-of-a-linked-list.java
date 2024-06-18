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

    public static ListNode mid(ListNode head){
        ListNode current = head;
        int size = 0;
        while(current != null){
            current = current.next;
            size++;
        }
        int i = 1;
        current = head;
        while(i < size/2){
            current = current.next;
            i++;
        }
        return current;
    }
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        else if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode prev = mid(head);
        prev.next = prev.next.next;
        return head;
    }
}