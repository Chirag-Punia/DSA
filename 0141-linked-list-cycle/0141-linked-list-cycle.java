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

    HashMap<ListNode,Integer> mpp = new HashMap<>();
    if(head == null){
        return false;
    }
    ListNode current = head;
    while(current.next != null){
        if(mpp.containsKey(current)){
            return true;
        }
        mpp.put(current,1);
        current = current.next;
    }
    return false;

    
    }
}