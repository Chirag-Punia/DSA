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
    public int gcd(int n,int m){
        if(m == 0)
            return n;
        return gcd(m,n%m);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null)return head;

        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null){
            int temp = gcd(curr.val,prev.val);
            ListNode newNode = new ListNode(temp);
            prev.next = newNode;
            newNode.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}