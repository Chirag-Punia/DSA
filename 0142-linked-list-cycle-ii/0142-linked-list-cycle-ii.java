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
    public ListNode detectCycle(ListNode head) {
        
    HashMap<ListNode,Integer> mpp = new HashMap<>();
    if(head == null){
        return null;
    }
    ListNode current = head;
    while(current.next != null){
        if(mpp.containsKey(current)){
            return current;
        }
        mpp.put(current,1);
        current = current.next;
    }
    return null;

    }
}