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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode tmp = head;
        while(tmp != null && tmp.next != null){
            if(tmp.val == tmp.next.val)
                tmp.next = tmp.next.next;
            else 
                tmp = tmp.next;
        }
        return head;
    }
}