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
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int i = 0;
        while(current != null){
            current = current.next;
            i++;
        }
        int j = 0;
        ListNode ans = head;
        while(j < (i/2)){
            ans = ans.next;
            j++;
        }
        
        return ans;
    }
}