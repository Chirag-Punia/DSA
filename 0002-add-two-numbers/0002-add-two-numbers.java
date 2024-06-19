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

    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        
        ListNode dummy = new ListNode(-1),temp = dummy;;
        int sum = 0,carry = 0,ans = 0,digit1 = 0,digit2 = 0;

        while(a!=null || b!=null || carry != 0){
            digit1 = (a)==null?0:a.val;
            digit2 = (b)==null?0:b.val;

            sum = digit1 + digit2 + carry;
            carry = sum / 10;
            ans = sum % 10;

            temp.next = new ListNode(ans);
            temp = temp.next;

            a = (a) == null?null:a.next;
            b = (b) == null?null:b.next;
        }

        temp.next = null;
        return dummy.next;
        
    }
}