/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

    //TORTOISE
    ListNode slow = head;
    ListNode fast = head;
    if(head == null || head.next == null || head.next.next == null){
        return false;
    }
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast){
            return true;
        }
    }
    return false;




    // BRUTE FORCE
    // HashMap<ListNode,Integer> mpp = new HashMap<>();
    // if(head == null){
    //     return false;
    // }
    // ListNode current = head;
    // while(current.next != null){
    //     if(mpp.containsKey(current)){
    //         return true;
    //     }
    //     mpp.put(current,1);
    //     current = current.next;
    // }
    // return false;

    
    }
}