// Problem : Linked List Cycle (LC 141)

import java.util.HashSet;

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public boolean checkCycle1(ListNode head){
        // store nodes address in a map
        HashSet<ListNode> present = new HashSet<>();

        ListNode itr = head;
        while(itr != null){
            // check if this node is already traversed
            if(present.contains(itr)) return true;
            // else add in map
            present.add(itr);
            itr = itr.next;
        }
        return false;
    }
    public boolean checkCycle2(ListNode head){
        ListNode slowItr = head;
        ListNode fastItr = head;

        while(fastItr != null && fastItr.next != null){
            slowItr = slowItr.next;
            fastItr = fastItr.next.next;

            if(fastItr == slowItr) return true;
        }

        return false;
    }
    public boolean hasCycle(ListNode head) {
        return checkCycle1(head);
        // return checkCycle2(head);
    }
}

public class Main {

}
