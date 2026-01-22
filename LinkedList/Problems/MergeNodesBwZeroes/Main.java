// Problem : Merge Nodes in Between Zeros (LC - 2181)


class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        // simulate the question descp

        ListNode modifiedHead = null;
        ListNode modifiedTail = null;
        int sum = 0;

        ListNode itr = head.next;
        while(itr != null){
            if(itr.val == 0){
                ListNode newNode = new ListNode(sum);

                if(modifiedHead == null){
                    modifiedHead = newNode;
                    modifiedTail = newNode;
                }
                else{
                    modifiedTail.next = newNode;
                    modifiedTail = newNode;
                }

                sum = 0;
            }

            sum += (itr.val);
            itr = itr.next;
        }

        return modifiedHead;
    }
}