/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;

        // BRUTE FORCE
        // HashMap<ListNode,Integer> mpp = new HashMap<>();
        // if(head == null){
        // return null;
        // }
        // ListNode current = head;
        // while(current.next != null){
        // if(mpp.containsKey(current)){
        // return current;
        // }
        // mpp.put(current,1);
        // current = current.next;
        // }
        // return null;

    }
}