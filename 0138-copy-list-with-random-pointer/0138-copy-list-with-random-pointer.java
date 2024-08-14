/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// class Solution {
//     public Node copyRandomList(Node head) {
//         Node temp = head;
//         HashMap<Node,Node> mpp = new HashMap<>();
//         while(temp != null){
//             mpp.put(temp,new Node(temp.val));
//             temp = temp.next;
//         }
//         temp = head;
//         while(temp != null){
//             Node copyNode = mpp.get(temp);
//             copyNode.next = mpp.get(temp.next);
//             copyNode.random = mpp.get(temp.random);
//             temp = temp.next;
//         }
//         return mpp.get(head);

//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and insert them next to original nodes
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        // Step 2: Assign the random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the original list from the copied list
        temp = head;
        Node dummy = head.next;
        Node res = dummy;
        while (temp != null) {
            temp.next = temp.next.next;
            if (dummy.next != null) {
                dummy.next = dummy.next.next;
            }
            temp = temp.next;
            dummy = dummy.next;
        }

        return res;
    }
}
