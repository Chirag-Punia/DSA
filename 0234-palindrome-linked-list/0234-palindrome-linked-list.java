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
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null){
            return head;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode midReverse(ListNode head){
        ListNode mid = mid(head);
        ListNode prev = null;
        ListNode next = head;
        while(next != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        if(head.next == null){
            return true;
        }
        ListNode right = midReverse(head);
        ListNode left = head;
        while(right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
        
    }
}