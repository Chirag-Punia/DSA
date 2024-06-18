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
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode newLeft,ListNode newRight){
        ListNode mergeLL = new ListNode(-1);
        ListNode temp = mergeLL;
        while(newLeft != null && newRight != null){
            if(newLeft.val < newRight.val){
                temp.next = newLeft;
                newLeft = newLeft.next;
            }
            else{
                temp.next = newRight;
                newRight = newRight.next;
            }
            temp = temp.next;
        }
        while(newLeft != null){
            temp.next = newLeft;
            newLeft = newLeft.next;
            temp = temp.next;
        }
        while(newRight != null){
            temp.next = newRight;
            newRight = newRight.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        //breaking into half
        ListNode mid = mid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode newLeft = mergeSort(head);
        ListNode newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);

    }


    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ans  = mergeSort(head);
        return ans;




        //VERY MUCH BRUTE FORCE
        // ArrayList<Integer> arr = new ArrayList<>();
        // ListNode temp = head;
        // while(temp != null){
        //     arr.add(temp.val);
        //     temp = temp.next;
        // }
        // Collections.sort(arr);
        // temp = head;
        // int i = 0;
        // while(temp != null){
        //     temp.val = arr.get(i);
        //     i++;
        //     temp = temp.next;
        // }
        // return head;


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