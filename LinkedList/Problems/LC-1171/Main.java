// Problem : Remove Zero Sum Consecutive Nodes from Linked List (LC - 1171)

import java.util.HashMap;

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // map to store prefix sum
        HashMap<Integer,ListNode> prefix = new HashMap<>();

        ListNode itr = head;
        int sum = 0;
        while(itr != null){
            sum += itr.val;

            if(sum == 0){
                ListNode seqEnd = itr;
                itr = itr.next;
                head = itr;
                seqEnd.next = null;
                prefix.clear();
            }
            else if(prefix.get(sum) != null){
                ListNode seqStart = prefix.get(sum).next;
                ListNode seqEnd = itr;
                itr = itr.next;

                // removing sequence
                prefix.get(sum).next = itr;
                seqEnd.next = null;

                // sanitize map
                while(seqStart != seqEnd){
                    sum = sum + seqStart.val;
                    ListNode temp = seqStart;
                    seqStart = seqStart.next;
                    temp.next = null;
                    prefix.remove(sum);
                }
                sum += seqStart.val;
                seqStart.next = null;
            }
            else{
                prefix.put(sum, itr);
                itr = itr.next;
            }
            
        }

        return head;
    }
}