class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
       
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }


        for(int i=0; i<=list.size()-k; i+=k) {
            reverse(i, i+k-1, list);
        }

        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i : list) {
            ListNode node = new ListNode(i);
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
        
    }

    static void reverse(int l, int r, List<Integer> list)
    {
        while(l < r){
            int t = list.get(l);
            list.set(l, list.get(r));
            list.set(r, t);
            ++l;
            --r;
        }
    }
}