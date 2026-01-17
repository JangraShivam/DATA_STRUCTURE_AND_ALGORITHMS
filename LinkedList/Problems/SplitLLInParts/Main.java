// Problem : Split Linked List in Parts (LC - 725)

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // get length of list
        int len = 0;
        ListNode itr = head;

        while(itr != null){
            len++;
            itr = itr.next;
        }

        // split the list
        int minNodes = len/k; // each part will get this much nodes
        int extraNodes = len%k; // will be distributed one by one from staring

        // intialize vector to store list parts head
        ListNode[] parts = new ListNode[k];

        // allocate nodes for each part
        for(int i = 0; i < k; i++){
            // check if list is empty
            if(head == null) break;

            // allocate nodes for current part
            parts[i] = head;
            itr = null;
            int currentPartNodes = minNodes;
            if(extraNodes > 0){
                currentPartNodes++;
                extraNodes--;
            }

            // allocate current part Nodes
            while(currentPartNodes > 0){
                itr = head;
                currentPartNodes--;
                head = head.next;
            }
            
            // disconnect current part
            itr.next = null;
        }

        return parts;
    }
}

public class Main{

    public static void main(String[] args) {
        
    }
}