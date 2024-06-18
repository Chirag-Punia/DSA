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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int size = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }
        int prevElementIndex = size - n;
        int j = 1;
        current = head;
        while(j < prevElementIndex){
            j++;
            current=current.next;
        }
        if(n == size){
            head = head.next;
            return head;
        }
        current.next = current.next.next;
        return head;
        

    }
}