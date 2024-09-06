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
    public ListNode remove(ListNode head,int num){
        while (head != null && head.val == num) 
            head = head.next;
        
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            if(temp.val == num)
                prev.next = temp.next;
            else
                prev = temp;
            temp = temp.next;  
        }
        return head;
    }
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        while(head != null && set.contains(head.val))
            head = head.next;
        
        ListNode temp = head;
        ListNode prev = head;
        while(temp != null){
            if(set.contains(temp.val)){
                prev.next = temp.next;
            }
            else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}