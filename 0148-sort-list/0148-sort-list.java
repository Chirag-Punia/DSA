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

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        int i = 0;
        while(temp != null){
            temp.val = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;


        //BUBBLE SORT
        // ListNode prev = head;
        // ListNode current = head;
        // ListNode count = head;
        // boolean i = true;
        // while(count != null){
        //     ListNode x = current.next;
        //     while(x != null){

        //         if(prev.val > x.val){
        //         int temp = prev.val;
        //         prev.val = x.val;
        //         x.val = temp;
        //         i = false;
        //         }
        //         prev = x;
        //         x = x.next;

        //     }
        //     if(i){
        //         break;
        //     }
        //     prev = head;
        //     current = head;
        //     count = count.next;
        // }
        // return head;
    }
}