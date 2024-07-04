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
    public ListNode mergeNodes(ListNode head) {
        ListNode tmp = head.next;
        ListNode dummy = new ListNode(-1);
        ListNode ansR = dummy;
        int ans = 0;
        while(tmp != null){
            if(tmp.val == 0){
                ListNode newNode = new ListNode(ans);
                dummy.next = newNode;
                dummy = dummy.next;
                ans = 0;
            }
            else{
                ans = ans + tmp.val;
            }
            tmp = tmp.next;
        }
        return ansR.next;
    }
}