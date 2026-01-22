// Problem : Rotate List (LC - 61)

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // if list is empty or single return
        if(head == null || head.next == null) return head;

        // get Length of list and end node
        int len = 0;
        ListNode tail = head;

        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        len++;

        //rotaing logic
        int effectiveRotate = k%len;
        if(effectiveRotate == 0) return head;

        tail.next = head; // join tail to head

        // disattach the list from effectiveRotate node from end
        int fromStart = len - effectiveRotate;
        int nodeNo = 1;

        while(nodeNo < fromStart){
            head = head.next;
            nodeNo++;
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;

    }
}